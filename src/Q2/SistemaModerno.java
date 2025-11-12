package Q2;

public class SistemaModerno {

    public static void main(String[] args) {

        SistemaBancarioLegado sistemaAntigo = new SistemaBancarioLegado();

        ProcessadorTransacoes meuProcessador = new AdaptadorBancario(sistemaAntigo);

        System.out.println("Teste 1: Transação em Reais (BRL)");
        RespostaAutorizacao resp1 = meuProcessador.autorizar("1111-2222-3333-4444", 150.75, "BRL");
        System.out.println("CLIENTE FINAL: " + resp1.toString());

        System.out.println("\nTeste 2: Transação em Dólar (USD)");
        RespostaAutorizacao resp2 = meuProcessador.autorizar("5555-6666-7777-8888", 99.00, "USD");
        System.out.println("CLIENTE FINAL: " + resp2.toString());

        System.out.println("\nTeste 3: Transação com Moeda Inválida (JPY)");
        RespostaAutorizacao resp3 = meuProcessador.autorizar("9999-0000-1111-2222", 5000.00, "JPY");
        System.out.println("CLIENTE FINAL: " + resp3.toString());
    }
}
