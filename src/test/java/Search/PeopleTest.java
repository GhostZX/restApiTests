package Search;

import Core.TestBase;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

class PeopleTest extends TestBase {

    @Test
    void byId() {
        given()
                .header("tokenId", USER_TOKEN)
                .when()
                .get(BASE_SEARCH_URL + "users/id/" + USER_ID)
                .then()
                .statusCode(200)
                .body("data.result.id", equalTo(USER_ID));
    }

    @Test
    void byCity() {
        given()
                .header("tokenId", USER_TOKEN)
                .when()
                .get(BASE_SEARCH_URL + "users/city/" + CITY_ID + "?count=1")
                .then()
                .statusCode(200)
                .body("data.result.items.people.id.collect()", hasSize(1));
    }

    @Test
    void WithFriends() {
        given()
                .header("tokenId", USER_TOKEN)
                .when()
                .get(BASE_SEARCH_URL + "users/friend?targetUserId=" + USER_ID + "&filters=friends" + "&count=1")
                .then()
                .statusCode(200)
                .body("data.result.users.id.collect()", hasSize(1));
    }

    @Test
    void withHelpOffers() {
        given()
                .header("tokenId", USER_TOKEN)
                .when()
                .get(BASE_SEARCH_URL + "users/helpoffers?count=1")
                .then()
                .statusCode(200)
                .body("data.result.items.people.id.collect()", hasSize(1));
    }

    @Test
    void byName() {
        given()
                .header("tokenId", USER_TOKEN)
                .when()
                .get(BASE_SEARCH_URL + "users/name?count=1" + "&searchText=" + "name")
                .then()
                .statusCode(200)
                .body("data.result.items.people.id.collect()", hasSize(1));
    }

}
