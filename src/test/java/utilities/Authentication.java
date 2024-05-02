package utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static stepDefinitions.EndToEndTestStepDefinitions.email;

public class Authentication {
    public static String generateToken() {

        Map<String, String> bodyMap = new HashMap<>();
        if (email == null) {
            bodyMap.put("email", "melad1@fake.com");
            bodyMap.put("password", "myPassword");
        } else {
            bodyMap.put("email", email);
            bodyMap.put("password", "Password.123");
        }

        Response response = given()
                .body(bodyMap)
                .contentType(ContentType.JSON)
                .post("https://thinking-tester-contact-list.herokuapp.com/users/login");
        return response.jsonPath().getString("token");
    }
}
