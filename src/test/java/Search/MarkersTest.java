package Search;

import Core.TestBase;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

class MarkersTest extends TestBase {
    @Test
    void all() {
        given()
                .header("tokenId", USER_TOKEN)
                .when()
                .get(BASE_SEARCH_URL + "markers/_all?count=1&lon=" + CITY_LON + "&lat=" + CITY_LAT + "")
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
    void allCluster() {
        given()
                .header("tokenId", USER_TOKEN)
                .when()
                .get(BASE_SEARCH_URL + "markers/_all?count=1&lon=" + CITY_LON + "&lat=" + CITY_LAT + "&isCluster=true&radius=10000000")
                .then()
                .statusCode(200)
                .body("data.result.cluster.find().types", equalTo("people,friends,places,rusPlaces,events,discounts"));
    }

    @Test
    void people() {
        given()
                .header("tokenId", USER_TOKEN)
                .when()
                .get(BASE_SEARCH_URL + "markers/people?count=1&lon=" + CITY_LON + "&lat=" + CITY_LAT + "")
                .then()
                .statusCode(200)
                .body("data.result.items.people.id.collect()", hasSize(1));
    }

    @Test
    void friends() {
        given()
                .header("tokenId", USER_TOKEN)
                .when()
                .get(BASE_SEARCH_URL + "markers/friends?count=1&lon=" + CITY_LON + "&lat=" + CITY_LAT + "")
                .then()
                .statusCode(200)
                .body("data.result.items.friends.id.collect()", hasSize(1));
    }

    @Test
    void places() {
        given()
                .header("tokenId", USER_TOKEN)
                .when()
                .get(BASE_SEARCH_URL + "markers/places?count=1&lon=" + CITY_LON + "&lat=" + CITY_LAT + "")
                .then()
                .statusCode(200)
                .body("data.result.items.places.id.collect()", hasSize(1));
    }

    @Test
    void rusPlaces() {
        given()
                .header("tokenId", USER_TOKEN)
                .when()
                .get(BASE_SEARCH_URL + "markers/rusPlaces?count=1&lon=" + CITY_LON + "&lat=" + CITY_LAT + "")
                .then()
                .statusCode(200)
                .body("data.result.items.rusPlaces.id.collect()", hasSize(1));
    }

    @Test
    void events() {
        given()
                .header("tokenId", USER_TOKEN)
                .when()
                .get(BASE_SEARCH_URL + "markers/events?count=1&lon=" + CITY_LON + "&lat=" + CITY_LAT + "")
                .then()
                .statusCode(200)
                .body("data.result.items.events.id.collect()", hasSize(1));
    }

    @Test
    void discounts() {
        given()
                .header("tokenId", USER_TOKEN)
                .when()
                .get(BASE_SEARCH_URL + "markers/discounts?count=1&lon=" + CITY_LON + "&lat=" + CITY_LAT + "")
                .then()
                .statusCode(200)
                .body("data.result.items.discounts.id.collect()", hasSize(1));
    }

    @Test
    void peopleCluster() {
        given()
                .header("tokenId", USER_TOKEN)
                .when()
                .get(BASE_SEARCH_URL + "markers/people?count=1&lon=" + CITY_LON + "&lat=" + CITY_LAT + "&isCluster=true&radius=10000000")
                .then()
                .statusCode(200)
                .body("data.result.cluster.find().types", equalTo("people"));
    }

    @Test
    void friendsCluster() {
        given()
                .header("tokenId", USER_TOKEN)
                .when()
                .get(BASE_SEARCH_URL + "markers/friends?count=1&lon=" + CITY_LON + "&lat=" + CITY_LAT + "&isCluster=true&radius=10000000")
                .then()
                .statusCode(200)
                .body("data.result.cluster.find().types", equalTo("friends"));
    }

    @Test
    void placesCluster() {
        given()
                .header("tokenId", USER_TOKEN)
                .when()
                .get(BASE_SEARCH_URL + "markers/places?count=1&lon=" + CITY_LON + "&lat=" + CITY_LAT + "&isCluster=true&radius=10000000")
                .then()
                .statusCode(200)
                .body("data.result.cluster.find().types", equalTo("places"));
    }

    @Test
    void rusPlacesCluster() {
        given()
                .header("tokenId", USER_TOKEN)
                .when()
                .get(BASE_SEARCH_URL + "markers/rusPlaces?count=1&lon=" + CITY_LON + "&lat=" + CITY_LAT + "&isCluster=true&radius=10000000")
                .then()
                .statusCode(200)
                .body("data.result.cluster.find().types", equalTo("rusPlaces"));
    }

    @Test
    void eventsCluster() {
        given()
                .header("tokenId", USER_TOKEN)
                .when()
                .get(BASE_SEARCH_URL + "markers/events?count=1&lon=" + CITY_LON + "&lat=" + CITY_LAT + "&isCluster=true&radius=10000000")
                .then()
                .statusCode(200)
                .body("data.result.cluster.find().types", equalTo("events"));
    }

    @Test
    void discountsCluster() {
        given()
                .header("tokenId", USER_TOKEN)
                .when()
                .get(BASE_SEARCH_URL + "markers/discounts?count=1&lon=" + CITY_LON + "&lat=" + CITY_LAT + "&isCluster=true&radius=10000000")
                .then()
                .statusCode(200)
                .body("data.result.cluster.find().types", equalTo("discounts"));
    }
}
