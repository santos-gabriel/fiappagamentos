package fiappagamentos.gateways.entities;

import fiappagamentos.entities.Pagamento;
import fiappagamentos.utils.enums.StatusPagamento;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "pagamentos")
public class PagamentoEntity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;

    private UUID idPedido;

    @Enumerated(EnumType.STRING)
    @NotNull
    private StatusPagamento status;

    public Pagamento to() {
        return Pagamento.builder()
                .id(this.id)
                .idPedido(this.idPedido)
                .statusPagamento(this.status)
            .build();
    }

    public PagamentoEntity from(Pagamento pagamento) {
        return PagamentoEntity.builder()
                .id(pagamento.getId())
                .idPedido(pagamento.getIdPedido())
                .status(pagamento.getStatusPagamento())
            .build();
    }
}
