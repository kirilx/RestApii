package com.github.headers;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.*;

public class ValidatableResponse {

    static final String BASE_URL = "https://api.github.com/";

    @Test
    void basicValidatableExample() {
        RestAssured.get(BASE_URL)
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .header("x-ratelimit-limit", "60");
    }

    @Test
    void SimpleHamcrestMatchers() {
        RestAssured.get(BASE_URL)
                .then()
                .statusCode(Matchers.lessThan(300))
                .header("cache-control", Matchers.containsString("value"))
                .time(lessThan(2L), TimeUnit.SECONDS)
                .header("etag",notNullValue())
                .header("etag", Matchers.not(emptyString()));


    }

    Map<String, String> expectedHeaders = Map.of("content-encoding", "gzip",
            "access-control-allow-origin", "*");

    @Test
    void usingMapsToTestHeaders() {
        RestAssured.get(BASE_URL)
                .then()
                .headers(
                        "content-encoding", "gzip",
                        "access-control-allow-origin", "*",
                        "cache-control", containsString("public"))
                .headers(expectedHeaders);

    }
}
