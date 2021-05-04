package getMethods;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class getMethod {
    @Test
    public void getListUsers()
    {
        RestAssured.baseURI = "https://reqres.in/";
        Response response = given()
                .header("content-type","application/json")
                .get("api/users?page=2");
        System.out.println(response.statusCode());
        Assert.assertEquals(response.statusCode(),200,"Expected Response code is 200 but found "+response.statusCode());
        System.out.println(response.asPrettyString());
    }

    @Test
    public void getSingleUsers()
    {
        RestAssured.baseURI = "https://reqres.in/";
        Response response = given()
                .header("content-type","application/json")
                .get("api/users/2");
        System.out.println(response.statusCode());
        Assert.assertEquals(response.statusCode(),200,"Expected Response code is 200 but found "+response.statusCode());
        System.out.println(response.asPrettyString());
    }

    @Test
    public void getSingleUserNotFound()
    {
        RestAssured.baseURI = "https://reqres.in/";
        Response response = given()
                .header("content-type","application/json")
                .get("api/users/23");
        System.out.println(response.statusCode());
        Assert.assertEquals(response.statusCode(),404,"Expected Response code is 404 but found "+response.statusCode());
        System.out.println(response.asPrettyString());
    }

    @Test
    public void getListResource()
    {
        RestAssured.baseURI = "https://reqres.in/";
        Response response = given()
                .header("content-type","application/json")
                .get("/api/unknown");
        System.out.println(response.statusCode());
        Assert.assertEquals(response.statusCode(),200,"Expected Response code is 200 but found "+response.statusCode());
        System.out.println(response.asPrettyString());
    }

    @Test
    public void getSingleResource()
    {
        RestAssured.baseURI = "https://reqres.in/";
        Response response = given()
                .header("content-type","application/json")
                .get("/api/unknown/2");
        System.out.println(response.statusCode());
        Assert.assertEquals(response.statusCode(),200,"Expected Response code is 200 but found "+response.statusCode());
        System.out.println(response.asPrettyString());
    }

    @Test
    public void getSingleResourceNotFound()
    {
        RestAssured.baseURI = "https://reqres.in/";
        Response response = given()
                .header("content-type","application/json")
                .get("/api/unknown/23");
        System.out.println(response.statusCode());
        Assert.assertEquals(response.statusCode(),404,"Expected Response code is 404 but found "+response.statusCode());
        System.out.println(response.asPrettyString());
    }

    @Test
    public void getDelayedResponse()
    {
        RestAssured.baseURI = "https://reqres.in/";
        Response response = given()
                .header("content-type","application/json")
                .get("/api/users?delay=3");
        System.out.println(response.statusCode());
        Assert.assertEquals(response.statusCode(),200,"Expected Response code is 200 but found "+response.statusCode());
        System.out.println(response.asPrettyString());
    }

}
