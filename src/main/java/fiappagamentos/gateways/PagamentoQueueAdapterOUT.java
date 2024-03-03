package fiappagamentos.gateways;

import fiappagamentos.interfaces.gateways.IPagamentoQueuePortOUT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PagamentoQueueAdapterOUT implements IPagamentoQueuePortOUT {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Value("${queue.pagamentos.name}")
    private String pagamentosFilaName;
    @Override
    public void publish(String message) {
        rabbitTemplate.convertAndSend(pagamentosFilaName, message);
        logger.info("Publicação na fila de pagamentos realizada com sucesso!!!");
    }
}
