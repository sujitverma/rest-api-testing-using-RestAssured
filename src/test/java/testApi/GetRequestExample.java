package testApi;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class GetRequestExample {

    public static void main(String[] args) {

        // Set base URI
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        // Send GET request to /users endpoint
        Response response = RestAssured
                .given()
                .when()
                .get("/users");

        // Parse response body to retrieve data where id = 3
        String responseBody = response.getBody().asString();
        System.out.println(responseBody);
        JsonPath jsonPath = new JsonPath(responseBody);
        String name = jsonPath.get("find {it.id == 3}.name");
        String email = jsonPath.get("find {it.id == 3}.email");

        // Print data where id = 3
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);

        // Print company details
        String companyName = jsonPath.get("find {it.id == 3}.company.name");
        String companyCatchPhrase = jsonPath.get("find {it.id == 3}.company.catchPhrase");
        String companyBs = jsonPath.get("find {it.id == 3}.company.bs");

        System.out.println("Company name: " + companyName);
        System.out.println("Catch phrase: " + companyCatchPhrase);
        System.out.println("Bs: " + companyBs);
    }
}
