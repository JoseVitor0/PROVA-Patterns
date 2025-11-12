package Q1;

public class SistemaFinanceiro {

    public static void main(String[] args) {

        ContextoFinanceiro dados = new ContextoFinanceiro(1000000.0, 0.05, 30);

        EstrategiaCalculoRisco algVaR = new CalculoVaR();
        EstrategiaCalculoRisco algES = new CalculoExpectedShortfall();
        EstrategiaCalculoRisco algStress = new CalculoStressTesting();

        ProcessadorRisco meuProcessador = new ProcessadorRisco(algVaR);
        System.out.println("Análise inicial (Padrão: VaR)");
        meuProcessador.executarCalculo(dados);

        meuProcessador.setEstrategia(algES);
        System.out.println("Análise de meio do dia (Mudou para: ES)");
        meuProcessador.executarCalculo(dados);

        meuProcessador.setEstrategia(algStress);
        System.out.println("Análise de fechamento (Mudou para: Stress Test)");
        meuProcessador.executarCalculo(dados);
    }
}
