package fiappagamentos.usecases;

import fiappagamentos.exceptions.entities.PedidoNaoEncontradoException;
import fiappagamentos.interfaces.gateways.IPedidoHttpPort;
import fiappagamentos.interfaces.usecases.IPedidoUseCasePort;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class PedidoUseCaseImpl implements IPedidoUseCasePort {

    private final IPedidoHttpPort pedidoHttpPort;

    @Override
    public boolean atualizarStatus(UUID idPedido) throws PedidoNaoEncontradoException {
        return pedidoHttpPort.atualizarStatus(idPedido);
    }

}
