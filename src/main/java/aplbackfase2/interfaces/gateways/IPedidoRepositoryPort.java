package aplbackfase2.interfaces.gateways;

import aplbackfase2.utils.enums.StatusPedido;
import aplbackfase2.exceptions.entities.PedidoNaoEncontradoException;
import aplbackfase2.entities.Pedido;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IPedidoRepositoryPort {
    Pedido atualizar(Pedido pedido);
    Pedido atualizarStatus(StatusPedido status, UUID idPedido) throws PedidoNaoEncontradoException;
    Optional<Pedido> buscarPorId(UUID idPedido);
}
