package Q4;

class ValidadorServicoSEFAZ extends ValidadorAbstrato {

    private static final int TIMEOUT_MAXIMO_MS = 2000; // 2 segundos

    @Override
    public void validar(ContextoValidacao contexto) {
        if (contexto.isFalhaCritica()) {
            System.out.println("[Pulando]... ValidadorServicoSEFAZ (falha anterior).");
            if (this.proximo != null) { this.proximo.validar(contexto); }
            return;
        }
        super.validar(contexto);
    }

    @Override
    protected ResultadoValidacao executarValidacao(DocumentoFiscal doc) {
        long tempoInicio = System.currentTimeMillis();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) { /* ignora */ }

        long tempoDecorrido = System.currentTimeMillis() - tempoInicio;

        if (tempoDecorrido > TIMEOUT_MAXIMO_MS) {
            return new ResultadoValidacao(false, "Timeout ao consultar SEFAZ.");
        }
        return new ResultadoValidacao(true, "SEFAZ OK.");
    }
}
