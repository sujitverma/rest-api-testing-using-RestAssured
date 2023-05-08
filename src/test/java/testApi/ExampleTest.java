package testApi;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class ExampleTest {

    @Test
    public void testUpdateAndPostRequest() {
        // Make a GET request and retrieve the response
        Response response = RestAssured.get("https://jsonplaceholder.typicode.com/posts/1");

        // Get the response body as a JSONObject
        JSONObject responseBody = new JSONObject(response.getBody().asString());

        // Update the title and body fields of the response body
        responseBody.put("title", "New Title");
        responseBody.put("body", "New Body");

        // Make a POST request with the updated response body
        Response postResponse = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(responseBody.toString())
                .post("https://jsonplaceholder.typicode.com/posts");

        // Verify the status code of the POST request
        postResponse.then().statusCode(201);
    }
}

