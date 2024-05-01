package com.typicode.jsonplaceholder.params;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class JsonParams {
    @Test(description = "Test with Params")
    void testParams() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        given()
                .queryParam("postId", 1)
                .when()
                .get("/comments")
                .then()
                .statusCode(200)
                .body("postId", everyItem(equalTo(1)));
    }
}
