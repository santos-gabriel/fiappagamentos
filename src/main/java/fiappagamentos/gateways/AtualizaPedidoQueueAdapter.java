package fiappagamentos.gateways;

import fiappagamentos.interfaces.gateways.IAtualizaPedidoQueuePort;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AtualizaPedidoQueueAdapter implements IAtualizaPedidoQueuePort {

    @Value("${queue.atualiza.pedido}")
    private String queueAtualizaPedido;

    @Override
    public void publish(String message) {

    }
}
