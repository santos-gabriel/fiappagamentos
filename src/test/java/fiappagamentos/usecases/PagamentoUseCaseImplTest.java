package fiappagamentos.usecases;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import fiappagamentos.interfaces.gateways.IPagamentoRepositoryPort;
import fiappagamentos.interfaces.usecases.IPagamentoUseCasePort;

class PagamentoUseCaseImplTest {

    private IPagamentoUseCasePort pagamentoUseCase;

    @Mock
    private IPagamentoRepositoryPort pagamentoRepositoryPort;

    AutoCloseable mock;

    @BeforeEach
    void setup() {
        mock = MockitoAnnotations.openMocks(this);
        pagamentoUseCase = new PagamentoUseCaseImpl(pagamentoRepositoryPort);
    }

    @AfterEach
    void tearDown() throws Exception {
        mock.close();
    }

}
