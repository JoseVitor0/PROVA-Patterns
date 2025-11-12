package Q1;

public class CalculoVaR implements EstrategiaCalculoRisco {

    @Override
    public String calcular(ContextoFinanceiro contexto) {
        System.out.println("LOG: Usando dados - Portfolio: " + contexto.getValorPortfolio());
        return "CÁLCULO [VaR]: Risco de perda máxima é X em " + contexto.getPeriodoDias() + " dias.";
    }
}
