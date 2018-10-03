package br.edu.utfpr.testrest.testrestassured;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import java.util.HashMap;
import java.util.Map;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author henriquenicolli
 * 
 * Testes para o projeto TesteNasaApi
 */
public class TesteNasaApi {

    @Test
    public void testDate() {
        when().
                get("https://api.nasa.gov/planetary/apod?api_key=rsLlfT0WROqwYvY3ZE4BEb5xEKfmFsAcbu5p7sqd").
        then()
                .statusCode(200).
                body("date", is("2018-10-03"));
    }
    
    @Test
    public void testImg() {
        when().
                get("https://api.nasa.gov/planetary/apod?api_key=rsLlfT0WROqwYvY3ZE4BEb5xEKfmFsAcbu5p7sqd").
        then()
                .statusCode(200).
                body("hdurl", is("https://apod.nasa.gov/apod/image/1810/NGC1898_Hubble_2913.jpg"));
    }
    
    @Test
    public void testTitle() {
        when().
                get("https://api.nasa.gov/planetary/apod?api_key=rsLlfT0WROqwYvY3ZE4BEb5xEKfmFsAcbu5p7sqd").
        then()
                .statusCode(200).
                body("title", is("NGC 1898: Globular Cluster in the Large Magellanic Cloud"));
    }
    

    @Test
    public void testAdicionarLivro() { 
        Map<String,String> user = new HashMap<>();
        user.put("email", "sydney@fife");
        user.put("password", "pistol");
        
        given().
                contentType(ContentType.JSON).
                body(user).

        when().
                post("https://reqres.in/api/register").
        then()
                .statusCode(201).
                body("token", is("QpwL5tke4Pnpja7X"));
    }     
}