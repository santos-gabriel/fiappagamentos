package aplbackfase2.interfaces.gateways;

import java.util.UUID;

import aplbackfase2.exceptions.entities.PedidoNaoEncontradoException;

public interface IPedidoHttpPort {
    boolean atualizarStatus(UUID idPedido) throws PedidoNaoEncontradoException;

}
