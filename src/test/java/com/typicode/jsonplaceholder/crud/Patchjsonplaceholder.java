package com.typicode.jsonplaceholder.crud;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Patchjsonplaceholder {

    @Test (description = "Test patch on jsonplaceholder")
    public void testPatchJsonPlaceHolder() {

        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";


        given()
                .contentType(ContentType.JSON)
                .body("{\"title\": \"dido\"}")
                .when()
                .patch("/posts/1")
                .then()
                .statusCode(200);
    }
}