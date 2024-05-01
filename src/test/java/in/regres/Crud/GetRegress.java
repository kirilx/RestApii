package in.regres.Crud;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class GetRegress {

    @Test(description = "Get single user on regress ")
    void GetUser() {
        RestAssured.baseURI = "https://reqres.in/api";
        given()
                .when()
                .get("/users/2")
                .then()
                .statusCode(200)
                .body("data.id", equalTo(2));
    }

    @Test(description = "SINGLE USER NOT FOUND ")
    void userNotFound() {
        RestAssured.baseURI = "https://reqres.in/api";
        given()
                .when()
                .get("users/23")
                .then()
                .statusCode(404)
                .body(is("{}"));
    }

    @Test(description = "List of resources on regress ")
    void list() {
        RestAssured.baseURI = "https://reqres.in/api";
        given()
                .when()
                .get("/unknown")
                .then()
                .statusCode(200)
                .body("total",equalTo(12));
    }
}