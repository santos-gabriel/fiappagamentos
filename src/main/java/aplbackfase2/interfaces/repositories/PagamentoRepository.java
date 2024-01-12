package aplbackfase2.interfaces.repositories;

import aplbackfase2.entities.Pagamento;
import aplbackfase2.gateways.entities.PagamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PagamentoRepository extends JpaRepository<PagamentoEntity, UUID> {

    Optional<PagamentoEntity> findAllByIdPedido(UUID idPedido);

}
