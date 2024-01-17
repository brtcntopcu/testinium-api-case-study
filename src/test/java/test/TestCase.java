package test;

import endpoints.Boards;
import endpoints.Card;
import endpoints.Lists;
import org.junit.jupiter.api.Test;
import java.util.Random;

public class TestCase {

    Boards boards = new Boards();
    Card cards = new Card();
    Lists lists = new Lists();
    Random random = new Random();

    @Test
    public void testCase() {
        String boardID = boards.postCreateBoard().jsonPath().get("id"); //Create board and get board ID
        String listID = boards.getFirstBoardListID(boardID); //Get first list in board to access cards

        cards.postCreateCard(listID).then().statusCode(200); //Create card
        cards.postCreateCard(listID).then().statusCode(200); //Create card

        int cardCountInList = lists.getCardListInList(listID).size(); //Get card count in list to use in for loop

        int rand_int1 = random.nextInt(lists.getCardListInList(listID).size()); //Get random number

        cards.putUpdateCard(lists.getSpecificCardIdInList(listID,rand_int1)); //Update random car

        for (int i = 0; i < cardCountInList ; i++) { //Delete all cards in list
            cards.delDeleteCard(lists.getSpecificCardIdInList(listID, 0));
        }

        boards.delDeleteBoard(boardID).then().statusCode(200); //Delete board
    }
}
