package com.typicode.jsonplaceholder.crud;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Putjsonplaceholder {
    @Test(description = "Test patch method on jsonplaceholder ")
    void testPatchMethod() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        given()
                .contentType(ContentType.JSON)
                .body("{\"title\": \"kiro\", \"body\": \"nova\", \"userId\": 1}")
                .when()
                .put("/posts/1")
                .then()
                .statusCode(200) ;
    }
}