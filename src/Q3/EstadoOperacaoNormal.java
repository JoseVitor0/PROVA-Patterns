package Q3;

public class EstadoOperacaoNormal implements EstadoUsina {

    @Override
    public void verificarSensores(UsinaNuclear usina) {
        int temp = usina.getTemperatura();

        if (temp > 300) {
            System.out.println("Risco: Temperatura > 300°C!");
            usina.setEstado(new EstadoAlertaAmarelo());
        } else {
            System.out.println("Reator estável. Temperatura: " + temp + "°C");
        }
    }

    @Override
    public String getNomeEstado() {
        return "OPERACAO_NORMAL";
    }
}
