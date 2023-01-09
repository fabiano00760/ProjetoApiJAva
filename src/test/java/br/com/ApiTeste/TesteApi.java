package br.com.ApiTeste;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.is;


public class TesteApi {

    Usuario usuario = new Usuario("fabiano_silva","QAAutomacao");

    @BeforeClass
    public static void setup(){
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        baseURI = "https://reqres.in/";
       // basePath = "/api/users";
    }

@Test
    public void listarUsiario(){

                when()
                .get("/api/users?page=2")
                .then()
                    .statusCode(200);
    }

    @Test
    public void criarUsuario(){
       given().
               contentType(ContentType.JSON).
                body(usuario).
       when().
               post("/api/users/2").
       then().
               statusCode(201).
               body("name",is("fabiano_silva")).
               body("job",is("QAAutomacao"));


    }
@Test
    public void editarUsuario(){
    given().
            contentType(ContentType.JSON).
            body(usuario).
            when().
            put("/api/users/2").
            then().
            statusCode(200).
            body("name",is("fabiano_silva")).
            body("job",is("QAAutomacao"));

    }
@Test
    public void removerUsuario(){
    given().
            when().
            delete("/api/users/2").
            then().
            statusCode(204);

    }
}
