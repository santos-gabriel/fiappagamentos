package fiappagamentos.gateways;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import fiappagamentos.interfaces.gateways.IAtualizaPedidoQueuePort;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AtualizaPedidoQueueAdapter implements IAtualizaPedidoQueuePort {

    @Value("${queue.atualiza.pedido}")
    private String queueAtualizaPedido;

    @Override
    public void publish(String message) {
        final AmazonSQS sqs = AmazonSQSClientBuilder.defaultClient();
        String queueStr = sqs.getQueueUrl(queueAtualizaPedido).getQueueUrl();
        SendMessageRequest sendMessageRequest = new SendMessageRequest()
                .withQueueUrl(queueStr)
                .withMessageBody(message)
                .withDelaySeconds(5);
        sqs.sendMessage(sendMessageRequest);
    }
}
