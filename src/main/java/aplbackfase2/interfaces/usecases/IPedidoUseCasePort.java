package aplbackfase2.interfaces.usecases;

import aplbackfase2.utils.enums.StatusPedido;
import aplbackfase2.exceptions.entities.PedidoNaoEncontradoException;

import java.util.UUID;

public interface IPedidoUseCasePort {
    boolean atualizarStatus(StatusPedido status, UUID idPedido) throws PedidoNaoEncontradoException;

}
