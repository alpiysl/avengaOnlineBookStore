package org.Utils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import org.Endpoints.RequestTypes;
import org.Reporter.ExtentReportManager;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class RestUtils {

    protected final static String BASE_URI;

    static {
        BASE_URI = "https://fakerestapi.azurewebsites.net";
    }

    // returns body request specification
    private static RequestSpecification requestSpecification() {
        return given()
                .baseUri(BASE_URI)
                .contentType(ContentType.JSON);
    }

    private static void printRequestReport(RequestSpecification requestSpecification, String requestType) {
        QueryableRequestSpecification queryableRequestSpecification = SpecificationQuerier.query(requestSpecification);
        ExtentReportManager.logInfoDetails("Endpoint is " + queryableRequestSpecification.getBaseUri());
        ExtentReportManager.logInfoDetails("Method is " + queryableRequestSpecification.getMethod());
        ExtentReportManager.logInfoDetails("Headers are ");
        ExtentReportManager.logHeaders(queryableRequestSpecification.getHeaders().asList());
        if (!requestType.equalsIgnoreCase("GET") && !requestType.equalsIgnoreCase("DELETE")) {
            Object body = queryableRequestSpecification.getBody();
            if (body != null) {
                ExtentReportManager.logInfoDetails("Request body is ");
                ExtentReportManager.logJson(body.toString());
            }
        }
    }

    private static void printResponseReport(Response response) {
        ExtentReportManager.logInfoDetails("Response status is " + response.getStatusCode());
        ExtentReportManager.logInfoDetails("Response Headers are ");
        ExtentReportManager.logHeaders(response.getHeaders().asList());
        ExtentReportManager.logInfoDetails("Response body is ");
        ExtentReportManager.logJson(response.getBody().prettyPrint());
    }

    public static void performPost(String endPoint, Map<String, Object> requestPayload, int statusCode) {
        RequestSpecification requestSpecification = requestSpecification();
        Response response = requestSpecification.body(requestPayload).log().all().post(endPoint);
        assertEquals(response.statusCode(), statusCode); // asserts status code with actual
        printRequestReport(requestSpecification, RequestTypes.POST.value);
        printResponseReport(response);
    }

    public static void performGet(String endPoint, int statusCode) {
        RequestSpecification requestSpecification = requestSpecification();
        Response response = requestSpecification.log().all().get(endPoint);
        assertEquals(response.statusCode(), statusCode); // asserts status code with actual
        printRequestReport(requestSpecification, RequestTypes.GET.value);
        printResponseReport(response);
    }

    public static void performGetWithId(String endPoint, int statusCode, int id) {
        RequestSpecification requestSpecification = requestSpecification();
        Response response = requestSpecification.log().all().get(endPoint, id);
        assertEquals(response.statusCode(), statusCode); // asserts status code with actual
        printRequestReport(requestSpecification, RequestTypes.GET.value);
        printResponseReport(response);
    }

    public static void performDelete(String endPoint, int id, int statusCode) {
        RequestSpecification requestSpecification = requestSpecification();
        Response response = requestSpecification.log().all().delete(endPoint, id);
        assertEquals(response.statusCode(), statusCode); // asserts status code with actual
        printRequestReport(requestSpecification, RequestTypes.DELETE.value);
        printResponseReport(response);
    }

    public static void performPut(String endPoint, Map<String, Object> requestPayload, int id, int statusCode) {
        RequestSpecification requestSpecification = requestSpecification();
        Response response = requestSpecification.body(requestPayload).put(endPoint, id);
        assertEquals(response.statusCode(), statusCode); // asserts status code with actual
        printRequestReport(requestSpecification, RequestTypes.PUT.value);
        printResponseReport(response);
    }
}