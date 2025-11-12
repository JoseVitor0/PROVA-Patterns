package Q2;

import java.util.HashMap;

public class AdaptadorBancario implements ProcessadorTransacoes {

    private SistemaBancarioLegado legado;

    public AdaptadorBancario(SistemaBancarioLegado sistemaLegado) {
        this.legado = sistemaLegado;
    }

    @Override
    public RespostaAutorizacao autorizar(String cartao, double valor, String moeda) {

        System.out.println("[Adaptador] Recebeu chamada moderna: Cartão " + cartao + ", Valor " + valor + ", Moeda " + moeda);

        HashMap<String, Object> parametrosLegados = new HashMap<>();
        parametrosLegados.put("cartaoInfo", cartao);
        parametrosLegados.put("valor", valor);

        int codigoMoedaLegado = switch (moeda.toUpperCase()) {
            case "USD" -> 1;
            case "EUR" -> 2;
            case "BRL" -> 3;
            default -> 99;
        };
        parametrosLegados.put("codigoMoeda", codigoMoedaLegado);

        parametrosLegados.put("codigoLoja", "LOJA_ONLINE_01");

        HashMap<String, Object> respostaLegada = this.legado.processarTransacao(parametrosLegados);

        System.out.println("[Adaptador] Recebeu resposta legada: " + respostaLegada.toString());

        RespostaAutorizacao respostaModerna = new RespostaAutorizacao();
        String statusLegado = (String) respostaLegada.get("status");

        if ("APROVADO".equals(statusLegado)) {
            respostaModerna.setSucesso(true);
            respostaModerna.setIdTransacao((String) respostaLegada.get("idTransacaoLegada"));
        } else {
            respostaModerna.setSucesso(false);
            respostaModerna.setMensagemErro((String) respostaLegada.get("erroMsg"));
        }

        return respostaModerna;
    }
}
