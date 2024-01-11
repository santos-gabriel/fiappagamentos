package aplbackfase2.interfaces.gateways;

import aplbackfase2.entities.Pagamento;
import aplbackfase2.exceptions.entities.PagamentoInvalidoException;

import java.util.Optional;
import java.util.UUID;

public interface IPagamentoRepositoryPort {
    Pagamento atualizar(Pagamento pagamento) throws PagamentoInvalidoException;
    Optional<Pagamento> localizarPorPedido(UUID idPedido);
}
