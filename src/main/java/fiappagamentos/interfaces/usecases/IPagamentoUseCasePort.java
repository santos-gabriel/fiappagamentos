package fiappagamentos.interfaces.usecases;

import fiappagamentos.entities.Pagamento;
import fiappagamentos.exceptions.entities.PedidoInvalidoException;
import fiappagamentos.interfaces.gateways.IAtualizaPedidoQueuePort;
import fiappagamentos.interfaces.gateways.INotificaClienteQueuePort;

import java.util.Optional;
import java.util.UUID;

public interface IPagamentoUseCasePort {
    Pagamento realizarPagamento(UUID idPedido, IAtualizaPedidoQueuePort atualizaPedidoQueuePort, INotificaClienteQueuePort notificaClienteQueuePort) throws PedidoInvalidoException;
    Pagamento recuzarPagamento(UUID idPedido, IAtualizaPedidoQueuePort atualizaPedidoQueuePort, INotificaClienteQueuePort notificaClienteQueuePort) throws PedidoInvalidoException;
    Optional<Pagamento> localizarPorPedido(UUID idPedido);
}
