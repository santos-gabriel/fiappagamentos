package aplbackfase2;

import aplbackfase2.utils.enums.StatusPagamento;
import aplbackfase2.utils.enums.StatusPedido;
import aplbackfase2.utils.enums.TipoProduto;
import aplbackfase2.entities.Cliente;
import aplbackfase2.entities.Pedido;
import aplbackfase2.entities.PedidoProduto;
import aplbackfase2.entities.Produto;
import aplbackfase2.entities.*;
import aplbackfase2.entities.Email;
import aplbackfase2.interfaces.usecases.IPedidoUseCasePort;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class AplBackFase2Application {

	public static void main(String[] args) {
		SpringApplication.run(AplBackFase2Application.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void runAfterStartup() {
		System.out.println("Application started");
	}


}
