package org.APISteps;

import org.Endpoints.Endpoints;

import static io.restassured.RestAssured.given;

public class APISteps implements Endpoints {

    protected final static String BASE_URI;
    static {
        BASE_URI = "https://fakerestapi.azurewebsites.net";
    }

    public static void getActivities() {
            given()
                .baseUri(BASE_URI)
                .get(GET_ACTIVITIES)
                .then()
                .assertThat()
                .statusCode(200);
    }

}
