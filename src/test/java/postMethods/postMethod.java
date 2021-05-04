package postMethods;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class postMethod {

    @Test
    public void create(){
        RestAssured.baseURI = "https://reqres.in/";
        String requestBody = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\",\n" +
                "    \"id\": \"887\",\n" +
                "    \"createdAt\": \"2021-05-04T12:49:46.049Z\"\n" +
                "}";
        Response response = given()
                .header("content-type","application/json")
                .and()
                .body(requestBody)
                .when()
                .post("/api/users");
        System.out.println(response.statusCode());
        Assert.assertEquals(response.statusCode(),201,"Expected Response code is 201 but found "+response.statusCode());
        System.out.println(response.asPrettyString());
    }

    @Test
    public void registerSuccessful(){
        RestAssured.baseURI = "https://reqres.in/";
        String requestBody = "{\n" +
                "    \"email\": \"eve.holt@reqres.in\",\n" +
                "    \"password\": \"pistol\"\n" +
                "}";
        Response response = given()
                .header("content-type","application/json")
                .and()
                .body(requestBody)
                .when()
                .post("/api/register");
        System.out.println(response.statusCode());
        Assert.assertEquals(response.statusCode(),200,"Expected Response code is 200 but found "+response.statusCode());
        System.out.println(response.asPrettyString());
    }

    @Test
    public void registerUnsuccessful(){
        RestAssured.baseURI = "https://reqres.in/";
        String requestBody = "{\n" +
                "    \"email\": \"sydney@fife\"\n" +
                "}";
        Response response = given()
                .header("content-type","application/json")
                .and()
                .body(requestBody)
                .when()
                .post("/api/register");
        System.out.println(response.statusCode());
        Assert.assertEquals(response.statusCode(),400,"Expected Response code is 400 but found "+response.statusCode());
        System.out.println(response.asPrettyString());
    }

    @Test
    public void loginSuccessful(){
        RestAssured.baseURI = "https://reqres.in/";
        String requestBody = "{\n" +
                "    \"email\": \"eve.holt@reqres.in\",\n" +
                "    \"password\": \"cityslicka\"\n" +
                "}";
        Response response = given()
                .header("content-type","application/json")
                .and()
                .body(requestBody)
                .when()
                .post("/api/login");
        System.out.println(response.statusCode());
        Assert.assertEquals(response.statusCode(),200,"Expected Response code is 200 but found "+response.statusCode());
        System.out.println(response.asPrettyString());
    }

    @Test
    public void loginUnuccessful(){
        RestAssured.baseURI = "https://reqres.in/";
        String requestBody = "{\n" +
                "    \"email\": \"peter@klaven\"\n" +
                "}";
        Response response = given()
                .header("content-type","application/json")
                .and()
                .body(requestBody)
                .when()
                .post("/api/login");
        System.out.println(response.statusCode());
        Assert.assertEquals(response.statusCode(),400,"Expected Response code is 400 but found "+response.statusCode());
        System.out.println(response.asPrettyString());
    }
}
