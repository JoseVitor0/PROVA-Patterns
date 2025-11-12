package Q4;

class ValidadorDatabase extends ValidadorAbstrato {
    @Override
    protected ResultadoValidacao executarValidacao(DocumentoFiscal doc) {
        // Simula a inserção
        System.out.println("[Ação]... Inserindo " + doc.getNumeroNota() + " no banco.");
        doc.setFoiInseridoNoBanco(true);
        return new ResultadoValidacao(true, "Nota não duplicada e inserida.");
    }

    @Override
    protected void executarRollback(DocumentoFiscal doc) {
        if (doc.isFoiInseridoNoBanco()) {
            System.out.println("[ROLLBACK]... Removendo " + doc.getNumeroNota() + " do banco.");
            doc.setFoiInseridoNoBanco(false);
        }
    }
}
