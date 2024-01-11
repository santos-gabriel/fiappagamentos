package aplbackfase2.usecases;

import aplbackfase2.utils.enums.StatusPedido;
import aplbackfase2.exceptions.entities.PedidoNaoEncontradoException;
import aplbackfase2.interfaces.gateways.IPedidoHttpPort;
import aplbackfase2.interfaces.usecases.IPedidoUseCasePort;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class PedidoUseCaseImpl implements IPedidoUseCasePort {

    private final IPedidoHttpPort pedidoHttpPort;

    @Override
    public boolean atualizarStatus(StatusPedido status, UUID idPedido) throws PedidoNaoEncontradoException {
        return pedidoHttpPort.atualizarStatus(status, idPedido);
    }

}
