package User;

import Core.TestBase;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

class RegistrationTest extends TestBase {

    @Tag("slow")
    @Test
    void valid() {
        jsonBody.put("email", "mail" + generated.stringValue(5) + "@grr.la");
        jsonBody.put("password", "1234567");
        jsonBody.put("name", "name" + generated.stringValue(5));
        jsonBody.put("surname", "surname" + generated.stringValue(5));
        jsonBody.put("gender", "M");
        jsonBody.put("agree", true);

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
                .body("data.result.userProfile.registrationEmail", equalTo("mail" + generated.stringValue(5) + "@grr.la"));
    }

    @Test
    void wrongEmail() {
        jsonBody.put("email", "ag;lkhe;ghqeger");
        jsonBody.put("password", "1234567");
        jsonBody.put("name", "name" + generated.stringValue(5));
        jsonBody.put("surname", "surname" + generated.stringValue(5));
        jsonBody.put("gender", "M");
        jsonBody.put("agree", true);

        given()
                .contentType("application/json; charset=UTF-8")
                .body(jsonBody)
                .when()
                .post(TEST_PROJECT_URL + "registration.json")
                .then()
                .statusCode(500)
                .body("data.error.textTranslit.email", equalTo("znachenie_adresa_elektronnoy_pochty_nedopustimo_"));
    }

    @Test
    void wrongGender() {

        jsonBody.put("email", "afasweqqgqeg@grr.la");
        jsonBody.put("password", "1234567");
        jsonBody.put("name", "name" + generated.stringValue(5));
        jsonBody.put("surname", "surname" + generated.stringValue(5));
        jsonBody.put("gender", "ggg");
        jsonBody.put("agree", true);

        given()
                .contentType("application/json; charset=UTF-8")
                .body(jsonBody)
                .when()
                .post(TEST_PROJECT_URL + "registration.json")
                .then()
                .statusCode(500)
                .body("data.error.code", equalTo(57005));
    }

}
