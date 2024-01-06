package aplbackfase2.interfaces.usecases;

import aplbackfase2.utils.enums.StatusPagamento;
import aplbackfase2.utils.enums.StatusPedido;
import aplbackfase2.exceptions.entities.PedidoNaoEncontradoException;
import aplbackfase2.entities.Pedido;
import aplbackfase2.entities.PedidoProduto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IPedidoUseCasePort {
    Pedido atualizarStatus(StatusPedido status, UUID idPedido) throws PedidoNaoEncontradoException;
    Pedido atualizarStatusPagamento(StatusPagamento status, UUID idPedido) throws PedidoNaoEncontradoException;
    Optional<Pedido> buscarPorId(UUID idPedido);
}
