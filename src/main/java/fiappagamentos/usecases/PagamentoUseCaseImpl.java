package fiappagamentos.usecases;

import fiappagamentos.entities.Pagamento;
import fiappagamentos.interfaces.gateways.IAtualizaPedidoQueuePort;
import fiappagamentos.interfaces.gateways.INotificaClienteQueuePort;
import fiappagamentos.interfaces.gateways.IPagamentoRepositoryPort;
import fiappagamentos.utils.enums.StatusPagamento;
import fiappagamentos.exceptions.entities.PedidoInvalidoException;
import fiappagamentos.exceptions.entities.PedidoUseCaseInvalidoException;
import fiappagamentos.interfaces.usecases.IPagamentoUseCasePort;
import fiappagamentos.interfaces.usecases.IPedidoUseCasePort;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class PagamentoUseCaseImpl implements IPagamentoUseCasePort {

    private final IPagamentoRepositoryPort pagamentoRepositoryPort;
    @Override
    @Transactional
    public Pagamento realizarPagamento(UUID idPedido, IAtualizaPedidoQueuePort atualizaPedidoQueuePort, INotificaClienteQueuePort notificaClienteQueuePort)
            throws PedidoInvalidoException, PedidoUseCaseInvalidoException {
        if (Objects.isNull(idPedido)) {
            throw new PedidoInvalidoException();
        }

        Optional<Pagamento> pagamentoDB = localizarPorPedido(idPedido);
        Pagamento pagamento = null;
        if (pagamentoDB.isPresent()) {
            pagamentoDB.get().setStatusPagamento(StatusPagamento.APROVADO);
            pagamento = pagamentoRepositoryPort.atualizar(pagamentoDB.get());
        } else {
            pagamento = pagamentoRepositoryPort.atualizar(new Pagamento(null, idPedido, StatusPagamento.APROVADO));
        }

        atualizaPedidoQueuePort.publish(pedidoToJson(idPedido, StatusPagamento.APROVADO.getDescricao()));
        notificaClienteQueuePort.publish(pedidoToJson(idPedido, StatusPagamento.APROVADO.getDescricao()));

        return Objects.nonNull(pagamento) ? pagamento : null;
    }

    @Override
    public Pagamento recuzarPagamento(UUID idPedido, IAtualizaPedidoQueuePort atualizaPedidoQueuePort, INotificaClienteQueuePort notificaClienteQueuePort) throws PedidoInvalidoException {
        if (Objects.isNull(idPedido)) {
            throw new PedidoInvalidoException();
        }
        Optional<Pagamento> pagamentoDB = localizarPorPedido(idPedido);
        if (pagamentoDB.isPresent()) {
            pagamentoDB.get().setStatusPagamento(StatusPagamento.RECUSADO);
            Pagamento pagamento = pagamentoRepositoryPort.atualizar(pagamentoDB.get());
            atualizaPedidoQueuePort.publish(pedidoToJson(idPedido, StatusPagamento.RECUSADO.getDescricao()));
            notificaClienteQueuePort.publish(pedidoToJson(idPedido, StatusPagamento.RECUSADO.getDescricao()));
            return pagamento;
        }

        Pagamento pagamento = pagamentoRepositoryPort
                .atualizar(new Pagamento(null, idPedido, StatusPagamento.RECUSADO));
        atualizaPedidoQueuePort.publish(pedidoToJson(idPedido, StatusPagamento.RECUSADO.getDescricao()));
        notificaClienteQueuePort.publish(pedidoToJson(idPedido, StatusPagamento.RECUSADO.getDescricao()));
        return pagamento;
    }

    @Override
    public Optional<Pagamento> localizarPorPedido(UUID idPedido) {
        return pagamentoRepositoryPort.localizarPorPedido(idPedido);
    }

    public String pedidoToJson(UUID idPedido, String status) {
        StringBuilder sb = new StringBuilder();
        sb.append("{'idPedido': '"+idPedido+"', ");
        sb.append("'statusPagamento': '"+status+"'}");
        return sb.toString();
    }

}
