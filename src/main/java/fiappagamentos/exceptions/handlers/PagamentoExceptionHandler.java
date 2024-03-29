package fiappagamentos.exceptions.handlers;

import fiappagamentos.controllers.PagamentoController;
import fiappagamentos.exceptions.entities.PedidoInvalidoException;
import fiappagamentos.exceptions.entities.PedidoNaoEncontradoException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(assignableTypes = {PagamentoController.class})
public class PagamentoExceptionHandler {
    @ExceptionHandler(PedidoInvalidoException.class)
    public ResponseEntity<StandardError> pedidoInvalido(PedidoInvalidoException e, HttpServletRequest request){
        StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Pedido inválido", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }

    @ExceptionHandler(PedidoNaoEncontradoException.class)
    public ResponseEntity<StandardError> pedidoNaoEncontrado(PedidoNaoEncontradoException e, HttpServletRequest request){
        StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), "Pedido não encontrado", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }
}
