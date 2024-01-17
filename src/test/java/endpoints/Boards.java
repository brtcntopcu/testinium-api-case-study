package endpoints;

import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import specs.RequestSpec;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Boards extends RequestSpec {

    public Boards() {
        super(BASE_URL);
    }
    public static String BASE_URL = "https://api.trello.com/1/boards";

    public Response postCreateBoard() {
         return given()
                .spec(getRequestSpecification())
                .queryParam("name","Board Name")
                .when()
                .post();
    }

    public Response getBoardLists(String boardID) {
        return given()
                .spec(getRequestSpecification())
                .get("/{id}/lists", boardID)
                ;
    }

    public String getFirstBoardListID(String boardID) {
        List<Map<String, Object>> products = getBoardLists(boardID)
                .as(new TypeRef<>() {});
        return products.getFirst().get("id").toString();
    }

    public Response delDeleteBoard(String boardID) {
        return given()
                .spec(getRequestSpecification())
                .delete("/{id}", boardID);
    }

}
