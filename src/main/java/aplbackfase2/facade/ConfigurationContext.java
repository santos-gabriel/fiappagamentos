package aplbackfase2.facade;

import aplbackfase2.interfaces.gateways.IPedidoRepositoryPort;
import aplbackfase2.interfaces.usecases.IPagamentoUseCase;
import aplbackfase2.interfaces.usecases.IPedidoUseCasePort;
import aplbackfase2.usecases.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationContext {

    @Bean
    public IPagamentoUseCase pagamentoUseCase() {
        return new PagamentoUseCaseImpl();
    }

    @Bean
    public IPedidoUseCasePort pedidoUseCasePort(IPedidoRepositoryPort pedidoRepositoryPort) {
        return new PedidoUseCaseImpl(pedidoRepositoryPort);
    }

}
