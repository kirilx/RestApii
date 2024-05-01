package com.typicode.jsonplaceholder.crud;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Postjsonplaceholder {

    @Test (description = "Test post method on jsonplaceholder ")
    void testPostMethod (){
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        given()
                .contentType(ContentType.JSON)
                .body("{\"title\": \"kiro\", \"body\": \"boss\", \"userId\": 1}")
                .when()
                .post("/posts")
                .then()
                .statusCode(201) ;

    }
}
