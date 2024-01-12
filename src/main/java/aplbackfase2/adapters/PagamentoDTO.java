package aplbackfase2.adapters;

import aplbackfase2.entities.Pagamento;
import aplbackfase2.utils.enums.StatusPagamento;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PagamentoDTO {
    private UUID pedido;
    private StatusPagamento status;
    private String menssagem;

    public PagamentoDTO (StatusPagamento status) {
        this.status = status;
        this.menssagem = status.getDescricao();
    }

    public PagamentoDTO(Pagamento pagamento) {
        this.pedido = pagamento.getIdPedido();
        this.status = pagamento.getStatusPagamento();
        this.menssagem = pagamento.getStatusPagamento().getDescricao();
    }
}
