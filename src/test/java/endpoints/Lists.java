package endpoints;

import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import specs.RequestSpec;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Lists extends RequestSpec {

    public Lists() {
        super(BASE_URL);
    }
    public static String BASE_URL = "https://api.trello.com/1/lists";

    public Response getCardsInList(String listID) {
        return given()
                .spec(getRequestSpecification())
                .when()
                .get("/{id}/cards",listID);
    }

    public String getSpecificCardIdInList(String listID, int cardIndex) {
        List<Map<String, Object>> products = getCardsInList(listID)
                .as(new TypeRef<List<Map<String, Object>>>() {});
        return products.get(cardIndex).get("id").toString();
    }

    public List getCardListInList(String listID) {
        return getCardsInList(listID)
                .as(new TypeRef<List<Map<String, Object>>>() {});
    }
}
