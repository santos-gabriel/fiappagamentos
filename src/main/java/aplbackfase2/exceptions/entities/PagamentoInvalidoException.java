package aplbackfase2.exceptions.entities;

public class PagamentoInvalidoException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public PagamentoInvalidoException() {
        super("Pagamento inválido");
    }
}
