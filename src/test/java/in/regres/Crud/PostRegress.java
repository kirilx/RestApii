package in.regres.Crud;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.given;


public class PostRegress {
    @Test(description = "Post on regress ")
    void postRegress() {
        RestAssured.baseURI = "https://reqres.in/api";
        given()
                .body("{\"name\" : \"kiro\",\"job\" : \"ovchar\"}")
                .when()
                .post("/users")
                .then()
                .statusCode(201);

    }

    @Test(description = "unsuccessful register  on regress ")
    void unsuccessfulRegister() {
        RestAssured.baseURI = "https://reqres.in/api";
        given()
                .body("{\"email\" : \"sydney@fife\"}")
                .when()
                .post("/register")
                .then()
                .statusCode(400)
                .body("error", equalTo("Missing email or username"));
    }
}