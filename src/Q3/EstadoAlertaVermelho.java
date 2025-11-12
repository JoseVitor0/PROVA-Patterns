package Q3;

public class EstadoAlertaVermelho implements EstadoUsina {

    @Override
    public void verificarSensores(UsinaNuclear usina) {

        if (usina.isSistemaResfriamentoFalhou()) {
            System.out.println("CATASTROFE: Sistema de resfriamento falhou!");
            usina.setEstado(new EstadoEmergencia());
        }
        else if (usina.getTemperatura() <= 400) {
            System.out.println("Info: Temperatura controlada, voltando para Amarelo.");
            usina.setEstado(new EstadoAlertaAmarelo());
        }
        else {
            System.out.println("!!! ALERTA MÁXIMO. Temperatura: " + usina.getTemperatura() + "°C");
        }
    }

    @Override
    public String getNomeEstado() {
        return "ALERTA_VERMELHO";
    }
}
