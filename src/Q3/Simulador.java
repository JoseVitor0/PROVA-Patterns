package Q3;

public class Simulador {

    public static void main(String[] args) throws InterruptedException {
        UsinaNuclear usina = new UsinaNuclear();

        // Usina desligada
        usina.verificarStatusGeral();

        // Ligando usina
        usina.ligarUsina();
        usina.verificarStatusGeral();

        // Aumentando temperatura para estado normal
        usina.setTemperatura(310);
        usina.verificarStatusGeral();

        // Aumentando para estado de alerta
        System.out.println("\n...Subindo temperatura para 410°C...");
        usina.setTemperatura(410);
        usina.verificarStatusGeral();
        usina.verificarStatusGeral();
        usina.verificarStatusGeral();
        usina.verificarStatusGeral();

        // Ativando modo de manutenção
        usina.ativarManutencao();
        usina.verificarStatusGeral();
        usina.verificarStatusGeral();
        usina.desativarManutencao();

        usina.verificarStatusGeral();

        usina.setSistemaResfriamentoFalhou(true);
        usina.verificarStatusGeral();

        usina.verificarStatusGeral();
        usina.setTemperatura(100);
        usina.verificarStatusGeral();
    }
}
