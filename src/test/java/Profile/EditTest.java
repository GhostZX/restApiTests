package Profile;

import Core.TestBase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

class EditTest extends TestBase {

    @Test
    void editEmail() {
        jsonEditCheck.put("gender", "M");
        jsonEditCheck.put("name", "Probe" + generated.stringValue(3));
        jsonEditCheck.put("surname", "Probe" + generated.stringValue(3));
        jsonEditCheck.put("email", "editEmail" + generated.stringValue(3) + "@grr.la");

        given()
                .contentType("application/json; charset=UTF-8")
                .header("tokenId", USER_TOKEN)
                .header("userId", USER_ID)
                .body(jsonEditCheck)
                .when()
                .post(TEST_PROJECT_URL + "profile/edit.json")
                .then()
                .statusCode(200)
                .body("data.result.id", is(USER_ID))
                .body("data.result.name", is("Probe" + generated.stringValue(3)))
                .body("data.result.gender", is("M"))
                .body("data.result.surname", is("Probe" + generated.stringValue(3)))
                .body("data.result.contactInfo.email", is("editEmail" + generated.stringValue(3) + "@grr.la"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"F", "M"})
    void editGenderParametrizedPositive(String argument) {
        jsonEditCheck.put("gender", argument);
        jsonEditCheck.put("name", "Probe" + generated.stringValue(3));
        jsonEditCheck.put("surname", "Probe" + generated.stringValue(3));

        given()
                .contentType("application/json; charset=UTF-8")
                .header("tokenId", USER_TOKEN)
                .header("userId", USER_ID)
                .body(jsonEditCheck)
                .when()
                .post(TEST_PROJECT_URL + "profile/edit.json")
                .then()
                .statusCode(200)
                .body("data.result.id", is(USER_ID))
                .body("data.result.name", is("Probe" + generated.stringValue(3)))
                .body("data.result.gender", is(argument))
                .body("data.result.surname", is("Probe" + generated.stringValue(3)));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11})
    void editMaritalStatusParametrizedPositive(int argument) {
        jsonEditCheck.put("gender", generatedGender.genderValue());
        jsonEditCheck.put("name", "Probe" + generated.stringValue(3));
        jsonEditCheck.put("surname", "Probe" + generated.stringValue(3));
        jsonEditCheck.put("maritalStatus", argument);

        given()
                .contentType("application/json; charset=UTF-8")
                .header("tokenId", USER_TOKEN)
                .header("userId", USER_ID)
                .body(jsonEditCheck)
                .when()
                .post(TEST_PROJECT_URL + "profile/edit.json")
                .then()
                .statusCode(200)
                .body("data.result.id", is(USER_ID))
                .body("data.result.name", is("Probe" + generated.stringValue(3)))
                .body("data.result.gender", is(generatedGender.genderValue()))
                .body("data.result.surname", is("Probe" + generated.stringValue(3)))
                .body("data.result.maritalStatus", is(argument));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void editEducationLevel(int argument) {
        jsonEditCheck.put("gender", generatedGender.genderValue());
        jsonEditCheck.put("name", "Probe" + generated.stringValue(3));
        jsonEditCheck.put("surname", "Probe" + generated.stringValue(3));
        jsonEditCheck.put("educationLevel", argument);

        given()
                .contentType("application/json; charset=UTF-8")
                .header("tokenId", USER_TOKEN)
                .header("userId", USER_ID)
                .body(jsonEditCheck)
                .when()
                .post(TEST_PROJECT_URL + "profile/edit.json")
                .then()
                .statusCode(200)
                .body("data.result.id", is(USER_ID))
                .body("data.result.name", is("Probe" + generated.stringValue(3)))
                .body("data.result.gender", is(generatedGender.genderValue()))
                .body("data.result.surname", is("Probe" + generated.stringValue(3)))
                .body("data.result.educationLevel", is(argument));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/ActivitySphereIdList.csv")
    void editActivitySphereIdList(String id, String value) {
        List<String> asList = new ArrayList<>(1);
        asList.add(id);

        jsonEditCheck.put("gender", generatedGender.genderValue());
        jsonEditCheck.put("name", "Probe" + generated.stringValue(3));
        jsonEditCheck.put("surname", "Probe" + generated.stringValue(3));
        jsonEditCheck.put("activitySphereIdList", asList);

        given()
                .contentType("application/json; charset=UTF-8")
                .header("tokenId", USER_TOKEN)
                .header("userId", USER_ID)
                .body(jsonEditCheck)
                .when()
                .post(TEST_PROJECT_URL + "profile/edit.json")
                .then()
                .statusCode(200)
                .body("data.result.id", is(USER_ID))
                .body("data.result.name", is("Probe" + generated.stringValue(3)))
                .body("data.result.gender", is(generatedGender.genderValue()))
                .body("data.result.surname", is("Probe" + generated.stringValue(3)))
                .body("data.result.activitySphere.id", contains(id))
                .body("data.result.activitySphere.name", contains(value));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/langIdList.csv")
    void editLanguageIdList(String id, String value) {
        List<String> asList = new ArrayList<>(1);
        asList.add(id);

        jsonEditCheck.put("gender", generatedGender.genderValue());
        jsonEditCheck.put("name", "Probe" + generated.stringValue(3));
        jsonEditCheck.put("surname", "Probe" + generated.stringValue(3));
        jsonEditCheck.put("langIdList", asList);

        given()
                .contentType("application/json; charset=UTF-8")
                .header("tokenId", USER_TOKEN)
                .header("userId", USER_ID)
                .body(jsonEditCheck)
                .when()
                .post(TEST_PROJECT_URL + "profile/edit.json")
                .then()
                .statusCode(200)
                .body("data.result.id", is(USER_ID))
                .body("data.result.name", is("Probe" + generated.stringValue(3)))
                .body("data.result.gender", is(generatedGender.genderValue()))
                .body("data.result.surname", is("Probe" + generated.stringValue(3)))
                .body("data.result.lang.id", contains(id))
                .body("data.result.lang.name", contains(value));
    }

    @ParameterizedTest
    @ValueSource(strings = {"probe", "ogionfrost"})
    void editSkypeContact(String value) {
        jsonEditCheck.put("gender", generatedGender.genderValue());
        jsonEditCheck.put("name", "Probe" + generated.stringValue(3));
        jsonEditCheck.put("surname", "Probe" + generated.stringValue(3));
        jsonEditCheck.put("skypeLogin", value);

        given()
                .contentType("application/json; charset=UTF-8")
                .header("tokenId", USER_TOKEN)
                .header("userId", USER_ID)
                .body(jsonEditCheck)
                .when()
                .post(TEST_PROJECT_URL + "profile/edit.json")
                .then()
                .statusCode(200)
                .body("data.result.id", is(USER_ID))
                .body("data.result.name", is("Probe" + generated.stringValue(3)))
                .body("data.result.gender", is(generatedGender.genderValue()))
                .body("data.result.surname", is("Probe" + generated.stringValue(3)))
                .body("data.result.contactInfo.skypeLogin", is(value));
    }

    @ParameterizedTest
    @ValueSource(strings = {"+79031234567", "+79251234567", "8 925 123 456 7"})
    void editTelephoneContact(String value) {
        jsonEditCheck.put("gender", generatedGender.genderValue());
        jsonEditCheck.put("name", "Probe" + generated.stringValue(3));
        jsonEditCheck.put("surname", "Probe" + generated.stringValue(3));
        jsonEditCheck.put("telephone", value);

        given()
                .contentType("application/json; charset=UTF-8")
                .header("tokenId", USER_TOKEN)
                .header("userId", USER_ID)
                .body(jsonEditCheck)
                .when()
                .post(TEST_PROJECT_URL + "profile/edit.json")
                .then()
                .statusCode(200)
                .body("data.result.id", is(USER_ID))
                .body("data.result.name", is("Probe" + generated.stringValue(3)))
                .body("data.result.gender", is(generatedGender.genderValue()))
                .body("data.result.surname", is("Probe" + generated.stringValue(3)))
                .body("data.result.contactInfo.telephone", is(value));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1989-07-19T20:35:09+0400", "1999-07-19T20:35:09+0400", "1800-07-10" })
    void editBirthday(String value) {
        jsonEditCheck.put("gender", generatedGender.genderValue());
        jsonEditCheck.put("name", "Probe" + generated.stringValue(3));
        jsonEditCheck.put("surname", "Probe" + generated.stringValue(3));
        jsonEditCheck.put("birthday", value);

        given()
                .contentType("application/json; charset=UTF-8")
                .header("tokenId", USER_TOKEN)
                .header("userId", USER_ID)
                .body(jsonEditCheck)
                .when()
                .post(TEST_PROJECT_URL + "profile/edit.json")
                .then()
                .statusCode(200)
                .body("data.result.id", is(USER_ID))
                .body("data.result.name", is("Probe" + generated.stringValue(3)))
                .body("data.result.gender", is(generatedGender.genderValue()))
                .body("data.result.surname", is("Probe" + generated.stringValue(3)))
                .body("data.result.birthday", containsString(value));
    }
}
