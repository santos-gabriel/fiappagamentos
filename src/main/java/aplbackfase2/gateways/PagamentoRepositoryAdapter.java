package aplbackfase2.gateways;

import aplbackfase2.entities.Pagamento;
import aplbackfase2.exceptions.entities.PagamentoInvalidoException;
import aplbackfase2.gateways.entities.PagamentoEntity;
import aplbackfase2.interfaces.gateways.IPagamentoRepositoryPort;
import aplbackfase2.interfaces.repositories.PagamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PagamentoRepositoryAdapter implements IPagamentoRepositoryPort {

    private final PagamentoRepository pagamentoRepository;

    @Override
    @Transactional
    public Pagamento atualizar(Pagamento pagamento) throws PagamentoInvalidoException {
        PagamentoEntity pagamentoEntity = new PagamentoEntity().from(pagamento);
        return this.pagamentoRepository.save(pagamentoEntity).to();
    }

    @Override
    public Optional<Pagamento> localizarPorPedido(UUID idPedido) {
        return this.pagamentoRepository.findAllByIdPedido(idPedido);
    }
}
