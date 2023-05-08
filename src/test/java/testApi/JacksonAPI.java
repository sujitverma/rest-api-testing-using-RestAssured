package testApi;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Iterator;

public class JacksonAPI {
  public static void main(String[] args) throws Exception {
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

    ObjectMapper objectMapper = new ObjectMapper();
    JsonNode jsonNode = objectMapper.readTree(jsonResponse);

    JsonNode dataArray = jsonNode.get("data");
    if (dataArray.isArray()) {
      Iterator<JsonNode> iterator = dataArray.iterator();
      while (iterator.hasNext()) {
        JsonNode data = iterator.next();
        if (data.get("id").asInt() == 2) {
          String name = data.get("name").asText();
          int age = data.get("age").asInt();
          String street = data.get("address").get("street").asText();
          String city = data.get("address").get("city").asText();
          String state = data.get("address").get("state").asText();
          String zip = data.get("address").get("zip").asText();
          System.out.println("Name: " + name);
          System.out.println("Age: " + age);
          System.out.println("Street: " + street);
          System.out.println("City: " + city);
          System.out.println("State: " + state);
          System.out.println("Zip: " + zip);
          break;
        }
      }
    }
  }
}
