package Q3;

public class UsinaNuclear {

    private EstadoUsina estadoAtual;
    private boolean emManutencao = false;

    private int temperatura = 25;
    private int tempoEmAlertaAmarelo = 0;
    private boolean sistemaResfriamentoFalhou = false;

    public UsinaNuclear() {
        this.estadoAtual = new EstadoDesligada();
    }

    public void verificarStatusGeral() {
        System.out.println("---");
        if (this.emManutencao) {
            System.out.println("[MANUTENÇÃO ATIVA] - Operações normais suspensas.");
            return;
        }

        System.out.println("Estado Atual: " + this.estadoAtual.getNomeEstado());

        this.estadoAtual.verificarSensores(this);
    }

    public void ligarUsina() {
        // Só podemos ligar se estiver desligada
        if (this.estadoAtual instanceof EstadoDesligada) {
            System.out.println("Ligando a usina...");
            setEstado(new EstadoOperacaoNormal());
        } else {
            System.out.println("Ação 'Ligar' inválida para o estado " + getNomeEstado());
        }
    }

    public void ativarManutencao() {
        System.out.println("\n[SISTEMA] ATIVANDO MODO MANUTENÇÃO.\n");
        this.emManutencao = true;
    }

    public void desativarManutencao() {
        System.out.println("\n[SISTEMA] DESATIVANDO MODO MANUTENÇÃO.\n");
        this.emManutencao = false;
    }

    public void setEstado(EstadoUsina novoEstado) {
        System.out.println("MUDANÇA DE ESTADO: " + this.estadoAtual.getNomeEstado() +
                " -> " + novoEstado.getNomeEstado());
        this.estadoAtual = novoEstado;

        if (!(novoEstado instanceof EstadoAlertaAmarelo)) {
            this.tempoEmAlertaAmarelo = 0;
        }
    }

    public String getNomeEstado() {
        return this.estadoAtual.getNomeEstado();
    }

    public int getTemperatura() { return temperatura; }
    public void setTemperatura(int t) {
        this.temperatura = t;
        System.out.println("[Sensor] Temperatura ajustada para: " + t + "°C");
    }

    public boolean isSistemaResfriamentoFalhou() { return sistemaResfriamentoFalhou; }
    public void setSistemaResfriamentoFalhou(boolean f) {
        this.sistemaResfriamentoFalhou = f;
        System.out.println("[Sensor] Sistema de Resfriamento Falhou: " + f);
    }

    public int getTempoEmAlertaAmarelo() { return tempoEmAlertaAmarelo; }
    public void incrementarTempoAmarelo() {
        this.tempoEmAlertaAmarelo += 10; // Simula passagem de tempo
        System.out.println("[Sensor] Tempo em Amarelo: " + this.tempoEmAlertaAmarelo + "s");
    }
}
