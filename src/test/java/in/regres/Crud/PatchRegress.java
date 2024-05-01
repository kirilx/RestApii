package in.regres.Crud;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PatchRegress {

    @Test(description = "Update user information with PATCH request")
    void updateUserInformation () {
        RestAssured.baseURI = "https://reqres.in/api";
        given()
                .body("{\"name\" : \"morpheus \",\"job\" : \"zion resident\"}")
                .when()
                .patch("/users/2")
                .then()
                .statusCode(200);
    }
}