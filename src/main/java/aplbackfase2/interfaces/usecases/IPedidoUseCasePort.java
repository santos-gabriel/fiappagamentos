package aplbackfase2.interfaces.usecases;

import aplbackfase2.exceptions.entities.PedidoNaoEncontradoException;

import java.util.UUID;

public interface IPedidoUseCasePort {
    boolean atualizarStatus(UUID idPedido) throws PedidoNaoEncontradoException;

}
