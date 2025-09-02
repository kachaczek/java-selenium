package tests.api;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import org.junit.jupiter.api.Test;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;

/**
 * ApiTest contains API tests using RestAssured.
 * It validates HTTP status codes and response body for Bing, Reqres, and GraphQL endpoints.
 * Allure annotations are used for reporting.
 */
public class ApiTest {

    @Test
    @Epic("Web UI Tests")
    @Feature("API Tests")
    @Story("Bing Home Page Status Code")
    @Severity(SeverityLevel.NORMAL)
    void testBingHomePage() {
        Response response = RestAssured.get("https://www.bing.com")
                .thenReturn();
        assertThat(response.getStatusCode(), is(200));
    }

    @Test
    @Epic("Web UI Tests")
    @Feature("API Tests")
    @Story("Regres Api response code")
    @Severity(SeverityLevel.NORMAL)
    void testRegresApi() {
        Response response =
            given()
            .queryParam("format", "json")
            .when()
            .get("https://reqres.in/api/users/2")
            .then()
            .statusCode(401)
            .extract().response();

        String body = response.getBody().asString();
        assertThat(body, containsString("Missing API key"));
    }

    @Test
    @Epic("Web UI Tests")
    @Feature("API Tests")
    @Story("GraphQL status code")
    @Severity(SeverityLevel.NORMAL)
    void testGraphQLUser() {
        String query = "{ user(id: 2) { id first_name } }";

        given()
            .contentType("application/json")
            .body("{\"query\":\"" + query + "\"}")
            .when()
            .post("https://example.com/graphql")
            .then()
            .statusCode(403);
    }
}