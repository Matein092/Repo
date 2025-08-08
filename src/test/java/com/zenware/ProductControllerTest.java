package com.zenware;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.*;

@QuarkusTest
class ProductControllerTest {

	@Test
    public void testGetAllProducts() {
        given()
          .when().get("/products")
          .then()
             .statusCode(200);
    }

    @Test
    public void testCreateProduct() {
        given()
          .contentType(ContentType.JSON)
          .body("{\"name\":\"soccer shoes\",\"price\":200000}")
          .when().post("/products")
          .then()
             .statusCode(anyOf(is(200), is(201)))
             .body("name", is("soccer shoes"));
    }

    @Test
    public void testGetProductById() {
        int id = 
            given()
              .contentType(ContentType.JSON)
              .body("{\"name\":\"Sandals\",\"price\":80000}")
              .when().post("/products")
              .then().extract().path("id");

        given()
          .when().get("/products/" + id)
          .then()
             .statusCode(200)
             .body("name", is("Sandals"));
    }

    @Test
    public void testDeleteProduct() {
        int id = 
            given()
              .contentType(ContentType.JSON)
              .body("{\"name\":\"soccer shoes\",\"price\":200000}")
              .when().post("/products")
              .then().extract().path("id");

        given()
          .when().delete("/products/" + id)
          .then()
             .statusCode(204);
    }
}


