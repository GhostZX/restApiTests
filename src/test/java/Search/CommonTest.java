package Search;

import Core.TestBase;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.nullValue;

class CommonTest extends TestBase {
    @Test
    void all() {
        given()
                .header("tokenId", USER_TOKEN)
                .when()
                .get(BASE_SEARCH_URL + "common/_all?count=1&searchText=auto")
                .then()
                .statusCode(200)
                .body("data.result.items.people.id.collect()", hasSize(1))
                .body("data.result.items.friends.id.collect()", hasSize(1))
                .body("data.result.items.places.id.collect()", hasSize(1))
                .body("data.result.items.rusPlaces.id.collect()", hasSize(1))
                .body("data.result.items.events.id.collect()", hasSize(1))
                .body("data.result.items.discounts.id.collect()", hasSize(1));
    }

    @Test
    void people() {
        given()
                .header("tokenId", USER_TOKEN)
                .when()
                .get(BASE_SEARCH_URL + "common/people?count=1&searchText=auto")
                .then()
                .statusCode(200)
                .body("data.result.items.people.id.collect()", hasSize(1))
                .body("data.result.items.friends.id.collect()", nullValue())
                .body("data.result.items.places.id.collect()", nullValue())
                .body("data.result.items.rusPlaces.id.collect()", nullValue())
                .body("data.result.items.events.id.collect()", nullValue())
                .body("data.result.items.discounts.id.collect()", nullValue());
    }

    @Test
    void friends() {
        given()
                .header("tokenId", USER_TOKEN)
                .when()
                .get(BASE_SEARCH_URL + "common/friends?count=1&searchText=auto")
                .then()
                .statusCode(200)
                .body("data.result.items.people.id.collect()", nullValue())
                .body("data.result.items.friends.id.collect()", hasSize(1))
                .body("data.result.items.places.id.collect()", nullValue())
                .body("data.result.items.rusPlaces.id.collect()", nullValue())
                .body("data.result.items.events.id.collect()", nullValue())
                .body("data.result.items.discounts.id.collect()", nullValue());
    }

    @Test
    void places() {
        given()
                .header("tokenId", USER_TOKEN)
                .when()
                .get(BASE_SEARCH_URL + "common/places?count=1&searchText=auto")
                .then()
                .statusCode(200)
                .body("data.result.items.people.id.collect()", nullValue())
                .body("data.result.items.friends.id.collect()", nullValue())
                .body("data.result.items.places.id.collect()", hasSize(1))
                .body("data.result.items.rusPlaces.id.collect()", nullValue())
                .body("data.result.items.events.id.collect()", nullValue())
                .body("data.result.items.discounts.id.collect()", nullValue());
    }

    @Test
    void rusPlaces() {
        given()
                .header("tokenId", USER_TOKEN)
                .when()
                .get(BASE_SEARCH_URL + "common/rusPlaces?userId=&count=1&searchText=auto")
                .then()
                .statusCode(200)
                .body("data.result.items.people.id.collect()", nullValue())
                .body("data.result.items.friends.id.collect()", nullValue())
                .body("data.result.items.places.id.collect()", nullValue())
                .body("data.result.items.rusPlaces.id.collect()", hasSize(1))
                .body("data.result.items.events.id.collect()", nullValue())
                .body("data.result.items.discounts.id.collect()", nullValue());
    }

    @Test
    void events() {
        given()
                .header("tokenId", USER_TOKEN)
                .when()
                .get(BASE_SEARCH_URL + "common/events?count=1&searchText=auto")
                .then()
                .statusCode(200)
                .body("data.result.items.people.id.collect()", nullValue())
                .body("data.result.items.friends.id.collect()", nullValue())
                .body("data.result.items.places.id.collect()", nullValue())
                .body("data.result.items.rusPlaces.id.collect()", nullValue())
                .body("data.result.items.events.id.collect()", hasSize(1))
                .body("data.result.items.discounts.id.collect()", nullValue());
    }

    @Test
    void discounts() {
        given()
                .header("tokenId", USER_TOKEN)
                .when()
                .get(BASE_SEARCH_URL + "common/discounts?count=1&searchText=auto")
                .then()
                .statusCode(200)
                .body("data.result.items.people.id.collect()", nullValue())
                .body("data.result.items.friends.id.collect()", nullValue())
                .body("data.result.items.places.id.collect()", nullValue())
                .body("data.result.items.rusPlaces.id.collect()", nullValue())
                .body("data.result.items.events.id.collect()", nullValue())
                .body("data.result.items.discounts.id.collect()", hasSize(1));
    }

    @Test
    void friendsPeopleDiscounts() {
        given()
                .header("tokenId", USER_TOKEN)
                .when()
                .get(BASE_SEARCH_URL + "common/friends,people,discounts?count=1&searchText=auto")
                .then()
                .statusCode(200)
                .body("data.result.items.people.id.collect()", hasSize(1))
                .body("data.result.items.friends.id.collect()", hasSize(1))
                .body("data.result.items.places.id.collect()", nullValue())
                .body("data.result.items.rusPlaces.id.collect()", nullValue())
                .body("data.result.items.events.id.collect()", nullValue())
                .body("data.result.items.discounts.id.collect()", hasSize(1));
    }

}



