package aplbackfase2.entities;

import lombok.*;

import java.math.BigDecimal;
import java.util.Objects;

@Getter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public final class ValorProduto {
    private BigDecimal valorProduto;

    public ValorProduto(BigDecimal valorProduto) {
        this.valorProduto = valorProduto.setScale(2);
    }
}
