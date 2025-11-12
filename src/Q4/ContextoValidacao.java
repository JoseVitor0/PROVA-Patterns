package Q4;

import java.util.ArrayList;
import java.util.List;

public class ContextoValidacao {

    private DocumentoFiscal documento;

    private int contadorFalhas = 0;
    private boolean falhaCritica = false;
    private boolean circuitBreakerAtivo = false;
    private List<String> mensagensFalha = new ArrayList<>();

    private static final int LIMITE_FALHAS = 3;

    public ContextoValidacao(DocumentoFiscal doc) {
        this.documento = doc;
    }

    public void registrarFalha(String mensagem) {
        this.contadorFalhas++;
        this.falhaCritica = true;
        this.mensagensFalha.add(mensagem);

        System.out.println("[FALHA] " + mensagem);

        if (this.contadorFalhas >= LIMITE_FALHAS) {
            System.out.println("!!! CIRCUIT BREAKER ATIVADO: " +
                    this.contadorFalhas + " falhas atingidas.");
            this.circuitBreakerAtivo = true;
        }
    }

    public DocumentoFiscal getDocumento() { return documento; }
    public boolean isFalhaCritica() { return falhaCritica; }
    public boolean isCircuitBreakerAtivo() { return circuitBreakerAtivo; }
    public List<String> getMensagensFalha() { return mensagensFalha; }
}
