package Q4;

class ValidadorSchemaXML extends ValidadorAbstrato {
    @Override
    protected ResultadoValidacao executarValidacao(DocumentoFiscal doc) {
        if (doc.getXmlConteudo() == null || doc.getXmlConteudo().isEmpty()) {
            return new ResultadoValidacao(false, "XML está vazio.");
        }
        return new ResultadoValidacao(true, "XML OK.");
    }
}
