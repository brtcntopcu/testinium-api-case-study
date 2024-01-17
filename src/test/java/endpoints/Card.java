package endpoints;

import io.restassured.response.Response;
import specs.RequestSpec;

import static io.restassured.RestAssured.given;

public class Card extends RequestSpec {
    public Card() {
        super(BASE_URL);
    }
    public static String BASE_URL = "https://api.trello.com/1/cards";

    public Response postCreateCard(String idList) {
        return given()
                .spec(getRequestSpecification())
                .queryParam("idList",idList)
                .queryParam("name","card name")
                .queryParam("desc","65a662fc9b3fb4c62f6891a2")
                .when()
                .post();
    }

    public void putUpdateCard(String cardId) {
        given()
                .spec(getRequestSpecification())
                .queryParam("name", "updated card name")
                .queryParam("desc", "updated desc")
                .when()
                .put("/{id}", cardId);
    }

    public void delDeleteCard(String cardId) {
        given()
                .spec(getRequestSpecification())
                .when()
                .delete("/{id}", cardId);
    }
}
