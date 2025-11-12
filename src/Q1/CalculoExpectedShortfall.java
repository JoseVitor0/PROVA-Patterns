package Q1;

public class CalculoExpectedShortfall implements EstrategiaCalculoRisco {

    @Override
    public String calcular(ContextoFinanceiro contexto) {
        System.out.println("LOG: Usando dados - Juros: " + contexto.getTaxaJuros());
        return "CÁLCULO [ES]: Média de perda em cenários extremos é Y.";
    }
}
