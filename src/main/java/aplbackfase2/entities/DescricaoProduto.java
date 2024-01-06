package aplbackfase2.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public final class DescricaoProduto {

    private String descricao;

    public DescricaoProduto(String descricaoProduto) {
        this.descricao = descricaoProduto;
    }

}
