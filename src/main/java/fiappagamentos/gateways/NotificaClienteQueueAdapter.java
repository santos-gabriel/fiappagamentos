package fiappagamentos.gateways;

import fiappagamentos.interfaces.gateways.INotificaClienteQueuePort;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class NotificaClienteQueueAdapter implements INotificaClienteQueuePort {

    @Value("${queue.notifica.cliente}")
    private String queueAtualizaPedido;

    @Override
    public void publish(String message) {

    }
}
