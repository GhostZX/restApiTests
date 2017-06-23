package Search;

import Core.TestBase;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;

class ChatTest extends TestBase {


    @Test
    void chatList() {
        given()
                .header("tokenId", USER_TOKEN)
                .when()
                .get(BASE_SEARCH_URL + "chat/list")
                .then()
                .statusCode(200)
                .body("data.result.chat_message.chatId.collect()", hasSize(greaterThan(0)));
    }

    @Test
    void messageList() {
        given()
                .header("tokenId", USER_TOKEN)
                .when()
                .get(BASE_SEARCH_URL + "chat/messages/2363")
                .then()
                .statusCode(200)
                .body("messages.id.collect()", hasSize(greaterThan(0)));
    }

    @Test
    void messageByTextTest() {
        given()
                .header("tokenId", USER_TOKEN)
                .when()
                .get(BASE_SEARCH_URL + "chat/search/messages?searchText=afsdfasf")
                .then()
                .statusCode(200)
                .body("item.id.collect()", hasSize(greaterThan(0)));
    }
}
