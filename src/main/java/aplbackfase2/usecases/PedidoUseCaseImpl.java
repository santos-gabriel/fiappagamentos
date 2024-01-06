package aplbackfase2.usecases;

import aplbackfase2.utils.enums.StatusPagamento;
import aplbackfase2.utils.enums.StatusPedido;
import aplbackfase2.exceptions.entities.PedidoNaoEncontradoException;
import aplbackfase2.entities.Pedido;
import aplbackfase2.interfaces.gateways.IPedidoRepositoryPort;
import aplbackfase2.interfaces.usecases.IPedidoUseCasePort;
import lombok.RequiredArgsConstructor;

import java.util.UUID;
import java.util.Date;
import java.util.Optional;

@RequiredArgsConstructor
public class PedidoUseCaseImpl implements IPedidoUseCasePort {

    private final IPedidoRepositoryPort pedidoRepositoryPort;

    @Override
    public Pedido atualizarStatus(StatusPedido status, UUID idPedido) throws PedidoNaoEncontradoException {
        Optional<Pedido> pedido = buscarPorId(idPedido);
        if (pedido.isEmpty()) {
            throw new PedidoNaoEncontradoException();
        }
        pedido.get().setStatusPedido(status);
        pedido.get().setDataAtualizacao(new Date());
        return pedidoRepositoryPort.atualizar(pedido.get());
    }

    @Override
    public Pedido atualizarStatusPagamento(StatusPagamento status, UUID idPedido) throws PedidoNaoEncontradoException {
        Optional<Pedido> pedido = buscarPorId(idPedido);
        if (pedido.isEmpty()) {
            throw new PedidoNaoEncontradoException();
        }
        pedido.get().setStatusPagamento(status);
        pedido.get().setDataAtualizacao(new Date());
        return pedidoRepositoryPort.atualizar(pedido.get());
    }

    @Override
    public Optional<Pedido> buscarPorId(UUID id) {
        return pedidoRepositoryPort.buscarPorId(id);
    }

}
