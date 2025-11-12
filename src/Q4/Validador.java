package Q4;

public interface Validador {

    void setProximo(Validador proximo);

    void validar(ContextoValidacao contexto);
}
