package Search;

import Core.TestBase;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

class EventsTest extends TestBase {
    @Test
    void eventById() {
        given()
                .header("tokenId", USER_TOKEN)
                .when()
                .get(BASE_SEARCH_URL + "events/id/" + "774")
                .then()
                .statusCode(200)
                .body("data.result.id", equalTo("774"));
    }
}
