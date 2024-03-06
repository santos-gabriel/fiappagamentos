package fiappagamentos.gateways;

import fiappagamentos.interfaces.gateways.IAtualizaPedidoQueuePort;
import org.springframework.stereotype.Service;

@Service
public class AtualizaPedidoQueueAdapter implements IAtualizaPedidoQueuePort {
    @Override
    public void publish(String message) {

    }
}
