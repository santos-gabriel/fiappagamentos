package aplbackfase2.usecases;


import aplbackfase2.entities.Pagamento;
import aplbackfase2.interfaces.gateways.IPagamentoRepositoryPort;
import aplbackfase2.utils.enums.StatusPagamento;
import aplbackfase2.exceptions.entities.PedidoInvalidoException;
import aplbackfase2.exceptions.entities.PedidoNaoEncontradoException;
import aplbackfase2.interfaces.usecases.IPagamentoUseCasePort;
import aplbackfase2.interfaces.usecases.IPedidoUseCasePort;
import lombok.RequiredArgsConstructor;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class PagamentoUseCaseImpl implements IPagamentoUseCasePort {

    private final IPagamentoRepositoryPort pagamentoRepositoryPort;

    @Override
    public boolean realizarPagamento(UUID idPedido) throws PedidoInvalidoException {
        if (Objects.isNull(idPedido)) {
            throw new PedidoInvalidoException();
        }
        Optional<Pagamento> pagamentoDB = localizarPorPedido(idPedido);
        if (pagamentoDB.isPresent()) {
            pagamentoDB.get().setStatusPagamento(StatusPagamento.APROVADO);
            Pagamento pagamento = pagamentoRepositoryPort.atualizar(pagamentoDB.get());
            return Objects.nonNull(pagamento);
        }

        Pagamento pagamento = pagamentoRepositoryPort.atualizar(new Pagamento(null, idPedido, StatusPagamento.APROVADO));
        return Objects.nonNull(pagamento);
    }

    @Override
    public Optional<Pagamento> localizarPorPedido(UUID idPedido) {
        return pagamentoRepositoryPort.localizarPorPedido(idPedido);
    }

}
