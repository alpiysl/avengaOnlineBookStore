package org.Utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import org.Reporter.ExtentReportManager;
import org.testng.Assert;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class RestUtils {

    protected final static String BASE_URI;

    static {
        BASE_URI = "https://fakerestapi.azurewebsites.net";
    }

    private static RequestSpecification postRequestSpecification(Object requestPayload) {
        return given()
                .baseUri(BASE_URI)
                .contentType(ContentType.JSON)
                .body(requestPayload);
    }

    private static RequestSpecification getRequestSpecification() {
        return given()
                .baseUri(BASE_URI)
                .contentType(ContentType.JSON);
    }

    private static void printRequestReport(RequestSpecification requestSpecification,String requestType) {
        QueryableRequestSpecification queryableRequestSpecification = SpecificationQuerier.query(requestSpecification);
        ExtentReportManager.logInfoDetails("Endpoint is " + queryableRequestSpecification.getBaseUri());
        ExtentReportManager.logInfoDetails("Method is " + queryableRequestSpecification.getMethod());
        ExtentReportManager.logInfoDetails("Headers are ");
        ExtentReportManager.logHeaders(queryableRequestSpecification.getHeaders().asList());
        if(!requestType.equalsIgnoreCase("GET")) {
            ExtentReportManager.logInfoDetails("Request body is ");
            ExtentReportManager.logJson(queryableRequestSpecification.getBody());
        }
    }

    private static void printResponseReport(Response response) {
        ExtentReportManager.logInfoDetails("Response status is " + response.getStatusCode());
        ExtentReportManager.logInfoDetails("Response Headers are ");
        ExtentReportManager.logHeaders(response.getHeaders().asList());
        ExtentReportManager.logInfoDetails("Response body is ");
        ExtentReportManager.logJson(response.getBody().prettyPrint());
    }

    public static Response performPost(String reqType,String endPoint, Map<String, Object> requestPayload) {
        RequestSpecification requestSpecification = postRequestSpecification(requestPayload);
        Response response =  requestSpecification.post(endPoint);
        printRequestReport(requestSpecification,reqType);
        printResponseReport(response);
        return response;
    }

    public static void performGet(String endPoint,String reqType,int statusCode) {
        RequestSpecification requestSpecification = getRequestSpecification();
        Response response =  requestSpecification.get(endPoint);
        assertEquals(response.statusCode(),statusCode);
        printRequestReport(requestSpecification,reqType);
        printResponseReport(response);
    }
}
