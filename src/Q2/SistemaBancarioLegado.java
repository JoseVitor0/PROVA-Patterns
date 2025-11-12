package Q2;

import java.util.HashMap;

public class SistemaBancarioLegado {

    public HashMap<String, Object> processarTransacao(HashMap<String, Object> parametros) {

        System.out.println("[Legado] Recebendo parâmetros brutos: " + parametros.toString());

        HashMap<String, Object> respostaLegada = new HashMap<>();

        if (!parametros.containsKey("codigoLoja")) {
            respostaLegada.put("status", "FALHA");
            respostaLegada.put("erroMsg", "CODIGO_LOJA_OBRIGATORIO");
            return respostaLegada;
        }

        int codigoMoeda = (int) parametros.get("codigoMoeda");
        if (codigoMoeda < 1 || codigoMoeda > 3) {
            respostaLegada.put("status", "FALHA");
            respostaLegada.put("erroMsg", "MOEDA_INVALIDA");
            return respostaLegada;
        }

        System.out.println("[Legado] Transação processada para a loja: " + parametros.get("codigoLoja"));
        respostaLegada.put("status", "APROVADO");
        respostaLegada.put("idTransacaoLegada", "TXN_LEGADO_" + System.currentTimeMillis());
        respostaLegada.put("valorConfirmado", parametros.get("valor"));

        return respostaLegada;
    }
}