package Q2;

public class RespostaAutorizacao {
    private boolean sucesso;
    private String idTransacao;
    private String mensagemErro;

    public boolean isSucesso() {
        return sucesso;
    }
    public void setSucesso(boolean sucesso) {
        this.sucesso = sucesso;
    }
    public String getIdTransacao() {
        return idTransacao;
    }
    public void setIdTransacao(String idTransacao) {
        this.idTransacao = idTransacao;
    }
    public String getMensagemErro() {
        return mensagemErro;
    }
    public void setMensagemErro(String mensagemErro) {
        this.mensagemErro = mensagemErro;
    }

    @Override
    public String toString() {
        if (sucesso) {
            return "Resposta [Sucesso=Sim, ID=" + idTransacao + "]";
        } else {
            return "Resposta [Sucesso=Não, Erro=" + mensagemErro + "]";
        }
    }
}
