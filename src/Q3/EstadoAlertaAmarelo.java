package Q3;

public class EstadoAlertaAmarelo implements EstadoUsina {

    @Override
    public void verificarSensores(UsinaNuclear usina) {
        int temp = usina.getTemperatura();

        if (temp > 400) {
            usina.incrementarTempoAmarelo();

            if (usina.getTempoEmAlertaAmarelo() > 30) {
                System.out.println("PERIGO: Temp > 400°C por mais de 30s!");
                usina.setEstado(new EstadoAlertaVermelho());
            } else {
                System.out.println("Aviso: Temp > 400°C. Monitorando tempo...");
            }

        } else if (temp <= 300) {
            System.out.println("Info: Temperatura normalizada.");
            usina.setEstado(new EstadoOperacaoNormal());

        } else {
            System.out.println("Monitorando... Temperatura: " + temp + "°C");
        }
    }

    @Override
    public String getNomeEstado() {
        return "ALERTA_AMARELO";
    }
}
