package User;

import Core.TestBase;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;

class LoginTest extends TestBase {
    @Test
    void valid() {
        jsonBody.put("username", EMAIL);
        jsonBody.put("password", PASSWORD);

        given()
                .contentType("application/json; charset=UTF-8")
                .body(jsonBody)
                .when()
                .post(TEST_PROJECT_URL + "login.json")
                .then()
                .statusCode(200)
                .body("data.result.userProfile.id", equalTo(USER_ID))
                .body("data.result.tokenId", equalTo(USER_TOKEN))
                .body("data.result.userProfile.emailEnabled", equalTo(false))
                .body("data.result.userProfile.emailDisabled", equalTo(false))
                .body("data.result.userProfile.roles", contains("ROLE_USER", "ROLE_ADMIN"));
    }

    @Test
    void emptyLogin() {
        jsonBody.put("username", "");
        jsonBody.put("password", PASSWORD);

        given()
                .contentType("application/json; charset=UTF-8")
                .body(jsonBody)
                .when()
                .post(TEST_PROJECT_URL + "login.json")
                .then()
                .statusCode(500)
                .body("data.error.textTranslit", equalTo("nepravilnyy_email_ili_parol_"));
    }

    @Test
    void invalidPassword() {
        jsonBody.put("username", EMAIL);
        jsonBody.put("password", "");

        given()
                .contentType("application/json; charset=UTF-8")
                .body(jsonBody)
                .when()
                .post(TEST_PROJECT_URL + "login.json")
                .then()
                .statusCode(500)
                .body("data.error.textTranslit", equalTo("nepravilnyy_email_ili_parol_"));
    }

    @Test
    void nonExistentLogin() {
        jsonBody.put("username", "1212121212121212121212341414141@grr.la");
        jsonBody.put("password", "");

        given()
                .contentType("application/json; charset=UTF-8")
                .body(jsonBody)
                .when()
                .post(TEST_PROJECT_URL + "login.json")
                .then()
                .statusCode(500)
                .body("data.error.textTranslit", equalTo("polzovatel_ne_nayden"));
    }
}
