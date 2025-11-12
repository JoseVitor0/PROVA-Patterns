package Q1;

public class ProcessadorRisco {

    private EstrategiaCalculoRisco estrategiaAtual;

    public ProcessadorRisco(EstrategiaCalculoRisco estrategiaInicial) {
        this.estrategiaAtual = estrategiaInicial;
    }

    public void setEstrategia(EstrategiaCalculoRisco novaEstrategia) {
        System.out.println("\nTrocando estratégia de análise");
        this.estrategiaAtual = novaEstrategia;
    }

    public void executarCalculo(ContextoFinanceiro contexto) {
        String resultado = this.estrategiaAtual.calcular(contexto);
        System.out.println("RESULTADO DA ANÁLISE: " + resultado);
    }
}
