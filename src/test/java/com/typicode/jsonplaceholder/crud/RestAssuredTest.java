package com.typicode.jsonplaceholder.crud;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class RestAssuredTest {

    @Test(description = "Test Get JsonPlaceHolder")
    public void testGetJsonPlaceHolder() {
        // Specify the base URL of the API you want to test
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        given()
                .when()
                .get("/posts")
                .then()
                .statusCode(200)
                // Verify that the response body contains a specific post with id 1
                .body("id", hasItem(1))
                // Verify that the response body contains a specific post with title "sunt aut facere repellat provident occaecati excepturi optio reprehenderit"
                .body("title", hasItem("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"));

        given()
                .when()
                .get("/posts/1/comments")
                .then()
                .assertThat().statusCode(200)
                .body("postId", everyItem(equalTo(1)));
    }
}
