package Q3;

public class EstadoDesligada implements EstadoUsina {

    @Override
    public void verificarSensores(UsinaNuclear usina) {
        System.out.println("Usina está desligada. Aguardando comando para ligar.");
    }

    @Override
    public String getNomeEstado() {
        return "DESLIGADA";
    }
}
