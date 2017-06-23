package Search;

import Core.TestBase;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

class DiscountsTest extends TestBase {
    @Test
    void byId() {
        given()
                .header("tokenId", USER_TOKEN)
                .when()
                .get(BASE_SEARCH_URL + "discount/id/" + "6993")
                .then()
                .statusCode(200)
                .body("data.result.id", equalTo("6993"));
    }
}
