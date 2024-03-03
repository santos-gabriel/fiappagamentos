package fiappagamentos.interfaces.gateways;

public interface IPagamentoQueuePortOUT {
    void publish(String message);
}
