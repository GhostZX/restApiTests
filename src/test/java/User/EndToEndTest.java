package User;

import Core.TestBase;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

class EndToEndTest extends TestBase {

    @Tag("slow")
    @Test
    void registerChangePasswordThenDeleteUser() {
        jsonBody.put("email", "mail" + generated.stringValue(5) + "@grr.la");
        jsonBody.put("password", PASSWORD);
        jsonBody.put("name", "name" + generated.stringValue(5));
        jsonBody.put("surname", "surname" + generated.stringValue(5));
        jsonBody.put("gender", "M");
        jsonBody.put("agree", true);

        tokenId =
                given()
                        .contentType("application/json; charset=UTF-8")
                        .body(jsonBody)
                        .when()
                        .post(TEST_PROJECT_URL + "registration.json")
                        .then()
                        .statusCode(200)
                        .body("data.result.userProfile.id", notNullValue())
                        .body("data.result.tokenId", notNullValue())
                        .body("data.result.userProfile.name", equalTo("name" + generated.stringValue(5)))
                        .body("data.result.userProfile.emailEnabled", equalTo(false))
                        .body("data.result.userProfile.emailDisabled", equalTo(false))
                        .body("data.result.userProfile.roles", contains("ROLE_USER"))
                        .body("data.result.userProfile.registrationEmail", equalTo("mail" + generated.stringValue(5) + "@grr.la"))
                        .extract()
                        .path("data.result.tokenId");


        jsonChangePassword.put("oldPassword", "1234567");
        jsonChangePassword.put("password", "12345678");
        given()
                .header("tokenId", tokenId)
                .contentType("application/json; charset=UTF-8")
                .body(jsonChangePassword)
                .when()
                .post(TEST_PROJECT_URL + "changePassword.json")
                .then()
                .statusCode(200)
                .body("data.result", equalTo(true));

        jsonChangePasswordCheck.put("username", "mail" + generated.stringValue(5) + "@grr.la");
        jsonChangePasswordCheck.put("password", "12345678");
        given()
                .contentType("application/json; charset=UTF-8")
                .body(jsonChangePasswordCheck)
                .when()
                .post(TEST_PROJECT_URL + "login.json")
                .then()
                .statusCode(200)
                .body("data.result.userProfile.id", notNullValue())
                .body("data.result.tokenId", equalTo(tokenId))
                .body("data.result.userProfile.name", equalTo("name" + generated.stringValue(5)))
                .body("data.result.userProfile.emailEnabled", equalTo(false))
                .body("data.result.userProfile.emailDisabled", equalTo(false))
                .body("data.result.userProfile.roles", contains("ROLE_USER"));

        given()
                .header("tokenId", tokenId)
                .when()
                .post(TEST_PROJECT_URL + "deleteAccount.json")
                .then()
                .statusCode(200)
                .body("data.result", equalTo(true));


        given()
                .header("tokenId", tokenId)
                .when()
                .get(TEST_PROJECT_URL + "profile/getProfile.json")
                .then()
                .statusCode(500)
                .body("data.error.textTranslit", equalTo("polzovatel_ne_aktiven"));
    }
}
