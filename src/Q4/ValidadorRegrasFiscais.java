package Q4;

class ValidadorRegrasFiscais extends ValidadorAbstrato {

    @Override
    public void validar(ContextoValidacao contexto) {
        if (contexto.isFalhaCritica()) {
            System.out.println("[Pulando]... ValidadorRegrasFiscais (falha anterior).");
            if (this.proximo != null) {
                this.proximo.validar(contexto);
            }
            return;
        }

        super.validar(contexto);
    }

    @Override
    protected ResultadoValidacao executarValidacao(DocumentoFiscal doc) {
        if (doc.getValorImpostos() <= 0) {
            return new ResultadoValidacao(false, "Cálculo de imposto inválido.");
        }
        return new ResultadoValidacao(true, "Impostos OK.");
    }
}
