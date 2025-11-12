package Q3;

public class EstadoEmergencia implements EstadoUsina {

    @Override
    public void verificarSensores(UsinaNuclear usina) {
        System.out.println("#Usina em estado de Emergência!#");
    }

    @Override
    public String getNomeEstado() {
        return "EMERGENCIA";
    }
}
