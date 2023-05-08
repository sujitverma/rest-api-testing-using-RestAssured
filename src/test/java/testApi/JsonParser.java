package testApi;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonParser {

    public static void main(String[] args) throws IOException {
        String jsonString = "{\"id\":1,\"name\":\"John\",\"age\":30,\"address\":{\"street\":\"123 Main St\",\"city\":\"New York\",\"state\":\"NY\",\"zip\":\"10001\"},\"phoneNumbers\":[{\"type\":\"home\",\"number\":\"555-555-1234\"},{\"type\":\"work\",\"number\":\"555-555-5678\"}]}";

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(jsonString);

        String name = jsonNode.get("name").asText();
        int age = jsonNode.get("age").asInt();
        String street = jsonNode.get("address").get("street").asText();
        String city = jsonNode.get("address").get("city").asText();
        String homePhoneNumber = jsonNode.get("phoneNumbers").get(0).get("number").asText();

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Street: " + street);
        System.out.println("City: " + city);
        System.out.println("Home Phone Number: " + homePhoneNumber);
    }
}


