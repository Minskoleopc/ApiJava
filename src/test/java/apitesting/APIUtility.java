package apitesting;


import io.restassured.RestAssured;
import io.restassured.response.Response;

public class APIUtility {
    private String baseUrl;

    // Constructor to initialize Base URL
    public APIUtility(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    // Generic API Request Method
    private Response sendRequest(String method, String endpoint, Object body) {
        switch (method.toUpperCase()) {
            case "GET":
                return RestAssured.given()
                        .baseUri(baseUrl)
                        .when()
                        .get(endpoint)
                        .then()
                        .extract()
                        .response();

            case "POST":
                return RestAssured.given()
                        .baseUri(baseUrl)
                        .header("Content-Type", "application/json")
                        .body(body)
                        .when()
                        .post(endpoint)
                        .then()
                        .extract()
                        .response();

            case "PUT":
                return RestAssured.given()
                        .baseUri(baseUrl)
                        .header("Content-Type", "application/json")
                        .body(body)
                        .when()
                        .put(endpoint)
                        .then()
                        .extract()
                        .response();

            case "DELETE":
                return RestAssured.given()
                        .baseUri(baseUrl)
                        .when()
                        .delete(endpoint)
                        .then()
                        .extract()
                        .response();

            default:
                throw new IllegalArgumentException("Invalid HTTP method: " + method);
        }
    }

    // Specific API Methods
    public Response get(String endpoint) {
        return sendRequest("GET", endpoint, null);
    }

    public Response post(String endpoint, Object body) {
        return sendRequest("POST", endpoint, body);
    }

    public Response put(String endpoint, Object body) {
        return sendRequest("PUT", endpoint, body);
    }

    public Response delete(String endpoint) {
        return sendRequest("DELETE", endpoint, null);
    }
}
