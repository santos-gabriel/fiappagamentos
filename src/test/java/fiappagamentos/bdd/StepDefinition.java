package fiappagamentos.bdd;

import fiappagamentos.adapters.PagamentoDTO;
import fiappagamentos.entities.Pagamento;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

public class StepDefinition {

    private Response response;
    private PagamentoDTO pagamentoResposta;
    private final String ENDPOINT_API_MENSAGENS = "http://localhost:9090/tech-challenge/pagamento";
    private final String PATH_JSON_SCHEMA_MENSAGEM = "schemas/pagamento.schema.json";

    @Quando("realizar um pagamento")
    public PagamentoDTO realizar_um_pagamento() {
        response = given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when()
                .post(ENDPOINT_API_MENSAGENS + "/{idPedido}", UUID.randomUUID());
        return response.then().extract().as(PagamentoDTO.class);
    }

    @Entao("o pagamento e registrado com sucesso")
    public void o_pagamento_e_registrado_com_sucesso() {
        response.then().statusCode(HttpStatus.OK.value());
    }

    @Entao("deve ser apresentado")
    public void deve_ser_apresentado() {
        response.then().body(matchesJsonSchemaInClasspath(PATH_JSON_SCHEMA_MENSAGEM));
    }

    @Dado("que um pedido já foi realizado")
    public void que_um_pedido_ja_foi_realizado() {
        pagamentoResposta = realizar_um_pagamento();
    }

    @Quando("efetuar a busca do pagamento do pedido")
    public void efetuar_a_busca_do_pagamento_do_pedido() {
        response = when()
                .get(ENDPOINT_API_MENSAGENS + "/{idPedido}", UUID.randomUUID());
    }

    @Entao("o pagamento do pedido e exibido com sucesso")
    public void o_pagamento_do_pedido_e_exibido_com_sucesso() {
        response.then()
                .body(matchesJsonSchemaInClasspath(PATH_JSON_SCHEMA_MENSAGEM));
    }
}
