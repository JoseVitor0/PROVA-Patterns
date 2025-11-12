package Q1;

public class CalculoStressTesting implements EstrategiaCalculoRisco {

    @Override
    public String calcular(ContextoFinanceiro contexto) {
        return "CÁLCULO [Stress Test]: Sistema sobreviveu ao cenário de crise (juros a " + (contexto.getTaxaJuros() * 5) + "%).";
    }
}