package aplbackfase2.interfaces.usecases;

import aplbackfase2.entities.Pagamento;
import aplbackfase2.utils.enums.StatusPagamento;

import java.util.Optional;
import java.util.UUID;

public interface IPagamentoUseCasePort {
    boolean realizarPagamento(UUID idPedido);
    Optional<Pagamento> localizarPorPedido(UUID idPedido);
}
