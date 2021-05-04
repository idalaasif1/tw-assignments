package putPatchDeleteMethods;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class putPatchDeleteMethods {
    @Test
    public void updatePut()
    {
        RestAssured.baseURI = "https://reqres.in/";
        String requestBody = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"zion resident\"\n" +
                "}";
        Response response = given()
                .header("content-type","application/json")
                .and()
                .body(requestBody)
                .when()
                .put("/api/users/2");
        System.out.println(response.statusCode());
        Assert.assertEquals(response.statusCode(),200,"Expected Response code is 200 but found "+response.statusCode());
        System.out.println(response.asPrettyString());
    }

    @Test
    public void updatePatch()
    {
        RestAssured.baseURI = "https://reqres.in/";
        String requestBody = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"zion resident\"\n" +
                "}";
        Response response = given()
                .header("content-type","application/json")
                .and()
                .body(requestBody)
                .when()
                .patch("/api/users/2");
        System.out.println(response.statusCode());
        Assert.assertEquals(response.statusCode(),200,"Expected Response code is 200 but found "+response.statusCode());
        System.out.println(response.asPrettyString());
    }

    @Test
    public void delete()
    {
        RestAssured.baseURI = "https://reqres.in/";
        Response response = given()
                .header("content-type","application/json")
                .delete("/api/users/2");
        System.out.println(response.statusCode());
        Assert.assertEquals(response.statusCode(),204,"Expected Response code is 204 but found "+response.statusCode());
        System.out.println(response.asPrettyString());
    }
}
