package Search;

import Core.TestBase;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

class PlaceTest extends TestBase {
    @Test
    void byId() {
        given()
                .header("tokenId", USER_TOKEN)
                .when()
                .get(BASE_SEARCH_URL + "places/id/" + USER_PLACE)
                .then()
                .statusCode(200)
                .body("data.result.id", equalTo(USER_PLACE));
    }

    @Test
    void byName() {
        given()
                .header("tokenId", USER_TOKEN)
                .when()
                .get(BASE_SEARCH_URL + "places/name?searchText=" + "auto" + "&count=2")
                .then()
                .statusCode(200)
                .body("data.result.items.places.id.collect()", hasSize(2));
    }

    @Test
    void byCity() {
        given()
                .header("tokenId", USER_TOKEN)
                .when()
                .get(BASE_SEARCH_URL + "places/city/" + CITY_ID)
                .then()
                .statusCode(200)
                .body("data.result.items.places.id.collect()", hasSize(greaterThan(0)));
    }

    @Test
    void placeTypeById() {
        given()
                .header("tokenId", USER_TOKEN)
                .when()
                .get(BASE_SEARCH_URL + "places/type/id/" + "12")
                .then()
                .statusCode(200)
                .body("data.result.id", equalTo("12"));
    }

}
