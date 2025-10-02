package org.Endpoints;

public enum RequestTypes {

    GET("GET"),
    POST("POST"),
    PUT("PUT"),
    DELETE("DELETE"),
    PATCH("PATCH"),
    HEAD("HEAD"),
    OPTIONS("OPTIONS");

    public final String value;

    RequestTypes(String rt) {
        this.value = rt;
    }

}
