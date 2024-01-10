package aplbackfase2.gateways;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import aplbackfase2.entities.Pedido;
import aplbackfase2.exceptions.entities.PedidoNaoEncontradoException;
import aplbackfase2.interfaces.gateways.IPedidoHttpPort;
import aplbackfase2.utils.enums.StatusPedido;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PedidoHttpAdapter implements IPedidoHttpPort {

    private final RestTemplate restTemplate;
    @Value("${pedido.service.url}")
    private final String urlServicePedido;

    @Override
    public Pedido atualizarStatus(StatusPedido statusPedido, UUID idPedido) throws PedidoNaoEncontradoException {

        StringBuilder urlRequsicao = new StringBuilder();
        urlRequsicao.append("/" + idPedido);
        urlRequsicao.append("/status/" + statusPedido.toString());

        restTemplate.put(urlRequsicao.toString(), null);

    }

}
