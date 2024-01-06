package aplbackfase2.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Objects;

@NoArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public final class NomeProduto {

    private String nome;

    public NomeProduto(String nomeProduto) {
        this.nome = nomeProduto.trim();
    }
}
