package aplbackfase2.gateways;

import aplbackfase2.exceptions.entities.PedidoNaoEncontradoException;
import aplbackfase2.gateways.entities.PedidoEntity;
import aplbackfase2.interfaces.gateways.IPedidoRepositoryPort;
import aplbackfase2.interfaces.repositories.PedidoRepository;
import aplbackfase2.entities.Pedido;
import aplbackfase2.utils.enums.StatusPedido;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
public class PedidoRepositoryAdapter implements IPedidoRepositoryPort {

    // private final PedidoRepository pedidoRepository;

    // @Override
    // @Transactional
    // public Pedido atualizar(Pedido pedido) {
    // PedidoEntity existingPedidoEntity =
    // this.pedidoRepository.findById(pedido.getIdPedido())
    // .orElseThrow(() -> new PedidoNaoEncontradoException("Pedido não encontrado,
    // id: " + pedido.getIdPedido()));
    // existingPedidoEntity = existingPedidoEntity.from(pedido, false);
    // return this.pedidoRepository.save(existingPedidoEntity).to();
    // }

    // @Override
    // @Transactional
    // public Pedido atualizarStatus(StatusPedido status, UUID idPedido) throws
    // PedidoNaoEncontradoException {
    // Pedido pedido = buscarPorId(idPedido)
    // .orElseThrow(() -> new PedidoNaoEncontradoException());
    // pedido.setStatusPedido(status);
    // return atualizar(pedido);
    // }

    // @Override
    // @Transactional(readOnly = true)
    // public Optional<Pedido> buscarPorId(UUID idPedido) {
    // return this.pedidoRepository.findByIdPedido(idPedido)
    // .map(PedidoEntity::to);
    // }

}
