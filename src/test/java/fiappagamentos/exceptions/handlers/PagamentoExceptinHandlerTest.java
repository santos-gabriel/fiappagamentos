package fiappagamentos.exceptions.handlers;

import fiappagamentos.exceptions.entities.PedidoInvalidoException;
import fiappagamentos.exceptions.entities.PedidoNaoEncontradoException;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;

import static org.mockito.ArgumentMatchers.any;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PagamentoExceptinHandlerTest {

    private PagamentoExceptionHandler handler = new PagamentoExceptionHandler();

    @Test
    void deveGerarExcecao_QuandoPedidoInvalido() throws Exception {
        var exception = new PedidoInvalidoException();
        var req = new MockHttpServletRequest();
        var res = handler.pedidoInvalido(exception, req);

        assertThat(res).isInstanceOf(ResponseEntity.class);
        assertThat(res.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }
    @Test
    void deveGerarExcecao_QuandoPedidoNaoForEncontrado() throws Exception {
        var exception = new PedidoNaoEncontradoException();
        var req = new MockHttpServletRequest();
        var res = handler.pedidoNaoEncontrado(exception, req);

        assertThat(res).isInstanceOf(ResponseEntity.class);
        assertThat(res.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }
}
