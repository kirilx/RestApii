package in.regres.Headers;


import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class HeaderCheckTest {
    public static final String BASE_URL = "https://reqres.in/api";

    @Test
    public void testHeaderCheck() {
        given()
                .when()
                .get(BASE_URL)
                .prettyPeek()
                .then()
                .statusCode(404)
                .header("Content-Encoding", notNullValue());
    }

    @Test(description = "Test content type Header")
    public void testHeaderContent() {
        given()
                .when()
                .get(BASE_URL)
                //.prettyPeek()
                .then()
                .statusCode(404)
                .header("Content-Type", equalTo("text/html; charset=utf-8"));
    }

}

