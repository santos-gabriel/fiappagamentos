package fiappagamentos.interfaces.usecases;

import fiappagamentos.utils.enums.StatusPagamento;

import java.util.UUID;

public interface INotificaClienteUseCasePort {
    void notificaCliente(UUID idPedido);
}
