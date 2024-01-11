package aplbackfase2.interfaces.gateways;

import java.util.UUID;

import aplbackfase2.exceptions.entities.PedidoNaoEncontradoException;
import aplbackfase2.utils.enums.StatusPedido;

public interface IPedidoHttpPort {
    boolean atualizarStatus(StatusPedido statusPedido, UUID idPedido) throws PedidoNaoEncontradoException;

}
