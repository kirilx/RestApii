package in.regres.Crud;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalTo;

public class DeleteRegress {
    @Test(description = "Delete  user on regress ")
    void DeleteUser() {
        RestAssured.baseURI = "https://reqres.in/api";
        given()
                .when()
                .delete("/users/2")
                .then()
                .statusCode(204);


    }
}