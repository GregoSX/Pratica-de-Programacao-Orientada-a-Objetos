import java.util.*;
public class MensagemNaoEncontradaException extends NoSuchElementException {
    private int id;

    public MensagemNaoEncontradaException(int id) {
        super("Mensagem não encontrada: ");
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
