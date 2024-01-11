package aplbackfase2.facade;

import aplbackfase2.interfaces.gateways.IPagamentoRepositoryPort;
import aplbackfase2.interfaces.gateways.IPedidoHttpPort;
import aplbackfase2.interfaces.usecases.IPagamentoUseCasePort;
import aplbackfase2.interfaces.usecases.IPedidoUseCasePort;
import aplbackfase2.usecases.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationContext {

    @Bean
    public IPagamentoUseCasePort pagamentoUseCase(IPagamentoRepositoryPort pagamentoRepositoryPort) {
        return new PagamentoUseCaseImpl(pagamentoRepositoryPort);
    }

    @Bean
    public IPedidoUseCasePort pedidoUseCasePort(IPedidoHttpPort pedidoHttpPort) {
        return new PedidoUseCaseImpl(pedidoHttpPort);
    }

}
