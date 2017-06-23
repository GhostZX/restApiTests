package Search;

import Core.TestBase;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

class CityTest extends TestBase {

    @Test
    void ByName() {
        given()
                .header("tokenId", USER_TOKEN)
                .when()
                .get(BASE_SEARCH_URL + "city/name?count=1&searchText=" + CITY_NAME)
                .then()
                .statusCode(200)
                .body("data.result.city.name.collect()", hasSize(equalTo(1)));
    }

    @Test
    void ById() {
        given()
                .header("tokenId", USER_TOKEN)
                .when()
                .get(BASE_SEARCH_URL + "city/id/" + CITY_ID)
                .then()
                .statusCode(200)
                .body("data.result.id", equalTo(CITY_ID))
                .body("data.result.InternationalName", equalTo(CITY_NAME));
    }
}
