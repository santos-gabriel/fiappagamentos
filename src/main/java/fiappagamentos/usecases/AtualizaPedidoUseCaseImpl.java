package fiappagamentos.usecases;

import fiappagamentos.interfaces.gateways.IAtualizaPedidoQueuePort;
import fiappagamentos.interfaces.usecases.IAtualizaPedidoUseCasePort;
import fiappagamentos.utils.enums.StatusPagamento;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class AtualizaPedidoUseCaseImpl implements IAtualizaPedidoUseCasePort {

    private final IAtualizaPedidoQueuePort atualizaPedidoQueuePort;
    @Override
    public void atualizaPedido(UUID idPedido, StatusPagamento status) {

    }
}
