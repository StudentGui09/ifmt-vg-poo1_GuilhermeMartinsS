package regras;

/** Uma regra da biblioteca foi violada. A mensagem explica qual. */
public class RegraException extends RuntimeException {
    public RegraException(String mensagem) {
        super(mensagem);
    }
}
