package aplbackfase2.controllers;

import aplbackfase2.entities.Pagamento;
import aplbackfase2.utils.enums.StatusPagamento;
import aplbackfase2.adapters.PagamentoDTO;
import aplbackfase2.controllers.requestValidations.PagamentoNotificacaoRequest;
import aplbackfase2.interfaces.usecases.IPagamentoUseCasePort;
import aplbackfase2.interfaces.usecases.IPedidoUseCasePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class PagamentoController {

    private final IPagamentoUseCasePort pagamentoUseCase;
    private final IPedidoUseCasePort pedidoUseCasePort;

    @PostMapping("/{idPedido}")
    public ResponseEntity<?> realizaPagamento(@PathVariable(name = "idPedido") UUID idPedido) {
        if (Objects.isNull(idPedido)) {
            return ResponseEntity.badRequest().build();
        }

        Pagamento res = pagamentoUseCase.realizarPagamento(idPedido, pedidoUseCasePort);

        if (Objects.isNull(res)) {
            return ResponseEntity.internalServerError().build();
        }

        return ResponseEntity.ok(new PagamentoDTO(res));
    }

    @GetMapping("/{idPedido}")
    public ResponseEntity<?> localizarPagamentoDoPedido(@PathVariable(name = "idPedido") UUID idPedido) {
        if (Objects.isNull(idPedido))
            return ResponseEntity.badRequest().build();

        Optional<Pagamento> pagamento = pagamentoUseCase.localizarPorPedido(idPedido);
        if (pagamento.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity
                .ok(new PagamentoDTO(pagamento.get()));
    }

    @PostMapping("/webhook")
    public ResponseEntity<?> webhook(
            @RequestBody @Valid PagamentoNotificacaoRequest pagamentoNotificacaoRequest) {
        if (Objects.isNull(pagamentoNotificacaoRequest.getPagamentoDados())
                || Objects.isNull(pagamentoNotificacaoRequest.getPagamentoDados().getIdPedido())) {
            return ResponseEntity.badRequest().build();
        }
        if (Objects.isNull(pagamentoNotificacaoRequest.getAcao()) || pagamentoNotificacaoRequest.getAcao().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        if (pagamentoNotificacaoRequest.getAcao().toLowerCase().equals("pagamento.aprovado")) {
            pagamentoUseCase.realizarPagamento(pagamentoNotificacaoRequest.getPagamentoDados().getIdPedido(), pedidoUseCasePort);
        }

        if (pagamentoNotificacaoRequest.getAcao().toLowerCase().equals("pagamento.recusado")) {
            pagamentoUseCase.recuzarPagamento(pagamentoNotificacaoRequest.getPagamentoDados().getIdPedido());
        }

        return ResponseEntity.ok().build();
    }
}
