package Q4;

class ValidadorCertificadoDigital extends ValidadorAbstrato {
    @Override
    protected ResultadoValidacao executarValidacao(DocumentoFiscal doc) {
        if (!doc.getCertificado().equals("CERT_VALIDO")) {
            return new ResultadoValidacao(false, "Certificado expirado ou revogado.");
        }
        return new ResultadoValidacao(true, "Certificado OK.");
    }
}
