package Q1;

public class ContextoFinanceiro {
    private double valorPortfolio;
    private double taxaJuros;
    private int periodoDias;

    public ContextoFinanceiro(double valorPortfolio, double taxaJuros, int periodoDias) {
        this.valorPortfolio = valorPortfolio;
        this.taxaJuros = taxaJuros;
        this.periodoDias = periodoDias;
    }

    public double getValorPortfolio() {
        return valorPortfolio;
    }

    public double getTaxaJuros() {
        return taxaJuros;
    }

    public int getPeriodoDias() {
        return periodoDias;
    }
}