package fiappagamentos.gateways;

import fiappagamentos.interfaces.gateways.INotificaClienteQueuePort;
import org.springframework.stereotype.Service;

@Service
public class NotificaClienteQueueAdapter implements INotificaClienteQueuePort {
    @Override
    public void publish(String message) {

    }
}
