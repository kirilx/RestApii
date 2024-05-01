package in.regres.Params;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;

import static io.restassured.RestAssured.given;

public class GetRegressParam {
    @Test(description = "Test Get-Param method on regress ")
    void testGetMethod() {
        RestAssured.baseURI = "https://reqres.in/api";

        given()
                .queryParam("page", 2)
                .when()
                .get("/users")
                .then()
                .statusCode(200)
                .body("total", equalTo(12));
    }
}
