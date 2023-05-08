package testApi;

import io.restassured.path.json.JsonPath;

public class Parsejson {

    public static void main(String[] args) {
        // Example JSON response
        String jsonResponse = "{\n" +
                "  \"data\": [\n" +
                "    {\n" +
                "      \"id\": 1,\n" +
                "      \"name\": \"John\",\n" +
                "      \"age\": 30,\n" +
                "      \"address\": {\n" +
                "        \"street\": \"123 Main St\",\n" +
                "        \"city\": \"New York\",\n" +
                "        \"state\": \"NY\",\n" +
                "        \"zip\": \"10001\"\n" +
                "      },\n" +
                "      \"phoneNumbers\": [\n" +
                "        {\n" +
                "          \"type\": \"home\",\n" +
                "          \"number\": \"555-1234\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"type\": \"work\",\n" +
                "          \"number\": \"555-5678\"\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 2,\n" +
                "      \"name\": \"Jane\",\n" +
                "      \"age\": 25,\n" +
                "      \"address\": {\n" +
                "        \"street\": \"456 Main St\",\n" +
                "        \"city\": \"Los Angeles\",\n" +
                "        \"state\": \"CA\",\n" +
                "        \"zip\": \"90001\"\n" +
                "      },\n" +
                "      \"phoneNumbers\": [\n" +
                "        {\n" +
                "          \"type\": \"home\",\n" +
                "          \"number\": \"555-4321\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"type\": \"work\",\n" +
                "          \"number\": \"555-8765\"\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        // Parse JSON response with RestAssured and JsonPath
        JsonPath jsonPath = new JsonPath(jsonResponse);
        int id = jsonPath.getInt("data[0].id");
        String name = jsonPath.get("data[0].name");
        int age = jsonPath.getInt("data[0].age");
        String street = jsonPath.get("data[0].address.street");
        String city = jsonPath.get("data[0].address.city");
        String state = jsonPath.get("data[0].address.state");
        String zip = jsonPath.get("data[0].address.zip");
        String homePhoneNumber = jsonPath.get("data[0].phoneNumbers.find { it.type == 'home' }.number");
        String workPhoneNumber = jsonPath.get("data[0].phoneNumbers.find { it.type == 'work' }.number");

        // Print retrieved data
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);

	}

}
