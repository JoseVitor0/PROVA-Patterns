package Q4;

public class Sistema {

    public static void main(String[] args) {

        Validador v1 = new ValidadorSchemaXML();
        Validador v2 = new ValidadorCertificadoDigital();
        Validador v3 = new ValidadorRegrasFiscais();
        Validador v4 = new ValidadorDatabase();
        Validador v5 = new ValidadorServicoSEFAZ();

        v1.setProximo(v2);
        v2.setProximo(v3);
        v3.setProximo(v4);
        v4.setProximo(v5);

        DocumentoFiscal nfe = new DocumentoFiscal();
        ContextoValidacao contexto = new ContextoValidacao(nfe);

        System.out.println("=== INICIANDO PROCESSAMENTO DA NF-e: " + nfe.getNumeroNota() + " ===");

        v1.validar(contexto);

        if (contexto.isFalhaCritica()) {
            System.out.println("=== PROCESSAMENTO FALHOU ===");
        } else {
            System.out.println("=== PROCESSAMENTO CONCLUÍDO COM SUCESSO ===");
        }

        System.out.println("Estado final do 'banco': Inserido = " + nfe.isFoiInseridoNoBanco());
    }
}
