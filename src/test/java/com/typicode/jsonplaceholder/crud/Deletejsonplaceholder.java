package com.typicode.jsonplaceholder.crud;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Deletejsonplaceholder {

    @Test(description = "Test delete jsonplaceholder ")
    public void testDeleteJsonPlaceHolder() {
        // Specify the base URL of the API you want to test
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        given()
                .when()
                .delete("/posts/1")
                .then()
                .statusCode(200);
    }
}
