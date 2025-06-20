package api;


import com.google.gson.Gson;
import config.ConfigLoader;
import io.restassured.RestAssured;
import io.restassured.builder.MultiPartSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.core.Serenity;

import java.nio.charset.StandardCharsets;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class BaseAPI {

    public BaseAPI() {
        RestAssured.baseURI = ConfigLoader.getBaseUrl();
    }

    public static void setReqSpec(RequestSpecification reqSpec) {
        RestAssured.requestSpecification = reqSpec;
    }

    // POST JSON
    public Response post(String endpoint, Object body, Map<String, String> headers) {
        Response response = given()
                .headers(headers)
                .body(body)
                .contentType("application/json")
                .post(endpoint);

        Serenity.setSessionVariable("lastResponse").to(response);
        return response;
    }

    public Response postForm(String endpoint, Map<String, String> formParams) {
        Response response = given()
                .contentType("application/x-www-form-urlencoded")
                .formParams(formParams)
                .when()
                .post(endpoint)
                .then()
                .log().ifValidationFails()
                .extract().response();

        Serenity.setSessionVariable("lastResponse").to(response);
        return response;
    }

    // GET
    public Response get(String endpoint, Map<String, String> headers) {
        Response response = given()
                .headers(headers)
                .get(endpoint);

        Serenity.setSessionVariable("lastResponse").to(response);
        return response;
    }

    // GET with query params
    public Response get(String endpoint, Map<String, String> headers, Map<String, String> queryParams) {
        Response response = given()
                .headers(headers)
                .queryParams(queryParams)
                .get(endpoint);

        Serenity.setSessionVariable("lastResponse").to(response);
        return response;
    }

    public String getJsonValue(Response response, String jsonLocator) {
        try {
            return this.getJsonPath(response).get(jsonLocator).toString();
        } catch (Exception E) {
            E.getMessage();
            return null;
        }
    }

    public JsonPath getJsonPath(Response r) {
        String json = r.asString();
        return new JsonPath(json);
    }

    protected void setUri(String host) {
        RestAssured.baseURI = host;
    }
    public static String convertObjectToJson(Object object) {
        return new Gson().toJson(object);
    }
    public Response sendPostWithFormDataTimeSheet(String url, Map<String, Object> formData) {
        RequestSpecification req = RestAssured.given().when();
        req.contentType("multipart/form-data");
        for (Map.Entry<String, Object> entry : formData.entrySet()) {
            req.multiPart(new MultiPartSpecBuilder(entry.getValue())
                    .controlName(entry.getKey())
                    .charset(StandardCharsets.UTF_8)
                    .build());
        }
        Response res = req
                .when()
                .relaxedHTTPSValidation()
                .post(url);
        return res;
    }
}
