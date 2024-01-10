package aplbackfase2.interfaces.gateways;

import java.util.UUID;

import aplbackfase2.entities.Pedido;
import aplbackfase2.exceptions.entities.PedidoNaoEncontradoException;
import aplbackfase2.utils.enums.StatusPagamento;
import aplbackfase2.utils.enums.StatusPedido;

public interface IPedidoHttpPort {
    Pedido atualizarStatus(StatusPedido statusPedido, UUID idPedido) throws PedidoNaoEncontradoException;

    // Pedido atualizarStatusPagamento(StatusPagamento status, UUID idPedido) throws
    // PedidoNaoEncontradoException;
}
