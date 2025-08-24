package tests.api;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;

public class ApiTest {

    @Test
    void testBingHomePage() {
        Response response = RestAssured.get("https://www.bing.com")
                .thenReturn();
        assertThat(response.getStatusCode(), is(200));
    }

    @Test
    void testRegresApi() {
        Response response =
            given()
                // .queryParam("q", "selenium testing")
                .queryParam("format", "json")
            .when()
                .get("https://reqres.in/api/users/2")
            .then()
                .statusCode(401)
                .extract().response();

        String body = response.getBody().asString();
        assertThat(body, containsString("Missing API key"));
    }
}