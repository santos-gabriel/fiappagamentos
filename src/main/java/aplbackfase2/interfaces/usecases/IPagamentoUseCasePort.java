package aplbackfase2.interfaces.usecases;

import aplbackfase2.entities.Pagamento;
import aplbackfase2.exceptions.entities.PedidoInvalidoException;
import aplbackfase2.interfaces.gateways.IPedidoHttpPort;
import aplbackfase2.utils.enums.StatusPagamento;

import java.util.Optional;
import java.util.UUID;

public interface IPagamentoUseCasePort {
    Pagamento realizarPagamento(UUID idPedido, IPedidoUseCasePort pedidoUseCasePort) throws PedidoInvalidoException;
    Pagamento recuzarPagamento(UUID idPedido) throws PedidoInvalidoException;
    Optional<Pagamento> localizarPorPedido(UUID idPedido);
}
