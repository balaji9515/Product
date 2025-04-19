package com.product.productApplication;


import com.product.productApplication.dto.ProductDto;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.MongoDBContainer;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductServiceApplicationTests
{

    @ServiceConnection
    static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:7.0.7");
    @LocalServerPort
    private Integer port;

    @BeforeEach
    void setUp()
    {
        RestAssured.baseURI="http://localhost:8080";
        RestAssured.port=port;
        RestAssured.registerParser("text/plain", Parser.JSON);
    }

    static
    {
        mongoDBContainer.start();
    }
    public  ProductDto getProductRequest()
    {

        return new ProductDto("Santoor","for bathing",BigDecimal.valueOf(35));
    }
    @Test
    void  shouldCreateProduct()
    {
        ProductDto productRequest =getProductRequest();

        RestAssured.given()
                .contentType("application/json")
                .body(productRequest)
                .when()
                .post("/product/create")
                .then()
                .log().all()
                .statusCode(200)
                .body("name", equalTo(productRequest.getName()))
                .body("description", equalTo(productRequest.getDescription()))
                .body("price", Matchers.is(productRequest.getPrice()
                        .intValueExact()));

    }
}
