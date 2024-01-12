package fiappagamentos.entities;


import fiappagamentos.utils.enums.StatusPagamento;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class Pagamento {
    private UUID id;
    private UUID idPedido;
    private StatusPagamento statusPagamento;

    public void aprovarPagamento() {
        this.statusPagamento = StatusPagamento.APROVADO;
    }

    public void recusarPagamento() {
        this.statusPagamento = StatusPagamento.RECUSADO;
    }

}
