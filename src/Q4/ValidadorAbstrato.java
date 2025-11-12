package Q4;


public abstract class ValidadorAbstrato implements Validador {

    protected Validador proximo;

    @Override
    public void setProximo(Validador proximo) {
        this.proximo = proximo;
    }

    @Override
    public void validar(ContextoValidacao contexto) {
        if (contexto.isCircuitBreakerAtivo()) {
            return;
        }

        System.out.println("[Validando]... " + this.getClass().getSimpleName());
        ResultadoValidacao resultado = this.executarValidacao(contexto.getDocumento());

        if (!resultado.sucesso) {
            contexto.registrarFalha(resultado.mensagem);
        }

        if (this.proximo != null) {
            this.proximo.validar(contexto);
        }

        if (contexto.isFalhaCritica()) {
            this.executarRollback(contexto.getDocumento());
        }
    }

    protected abstract ResultadoValidacao executarValidacao(DocumentoFiscal doc);

    protected void executarRollback(DocumentoFiscal doc) {
    }
}
