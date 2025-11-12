package Q4;

public class DocumentoFiscal {
    private String xmlConteudo = "<nfe>...</nfe>";
    private String certificado = "CERT_VALIDO";
    private double valorImpostos = 100.0;
    private String numeroNota = "NFe-12345";

    private boolean foiInseridoNoBanco = false;

    public String getNumeroNota() { return numeroNota; }
    public String getXmlConteudo() { return xmlConteudo; }
    public String getCertificado() { return certificado; }
    public double getValorImpostos() { return valorImpostos; }

    public boolean isFoiInseridoNoBanco() { return foiInseridoNoBanco; }
    public void setFoiInseridoNoBanco(boolean v) { this.foiInseridoNoBanco = v; }
}
