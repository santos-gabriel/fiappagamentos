package fiappagamentos.usecases;

import fiappagamentos.interfaces.gateways.INotificaClienteQueuePort;
import fiappagamentos.interfaces.usecases.INotificaClienteUseCasePort;
import fiappagamentos.utils.enums.StatusPagamento;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class NotificaClienteUseCaseImpl implements INotificaClienteUseCasePort {
    
    private final INotificaClienteQueuePort notificaClienteQueuePort;
    @Override
    public void notificaCliente(UUID idPedido, StatusPagamento statusPagamento) {

    }
}
