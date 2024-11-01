/**
 * OrderAndChaos.java
 *
 * Order and Chaos is on a 6x6 game board
 * Order plays first, then turns alternate.
 * Order aims to get five like pieces in a row.
 * The opponent Chaos endeavors to prevent this.
 */

import java.util.ArrayList;
import java.util.List;

public class OrderAndChaos extends TTTGame{
    private List<CellGroup.MarkType> types;
    private int firstPlayIndex;

    //  order and chaos constructor
    public OrderAndChaos(){
        super();
        firstPlayIndex = 0;
        types = new ArrayList<>();
        types.add(CellGroup.MarkType.ONE);
        types.add(CellGroup.MarkType.TWO);
    }
    // override
    // print welcome message
    // game description
    public void printWelCome(){
        String message = "\nOrder and Chaos is on a 6x6 game board.\n";
        message += "Order plays first, then turns alternate. ";
        message += "Order aims to get five like pieces in a row.\n";
        message += "The opponent Chaos endeavors to prevent this.";
        System.out.println(message);
    }

    // override
    // determine which player first
    public void determinePlayer(){
        firstPlayIndex = getPlayerIndex();
        playerTurn = firstPlayIndex;
    }

    // config board size 6*6
    // consecutive number is 5
    public void configBoard(){
        board = new Board(6,6);
        board.setConsecutiveNumber(5);
    }

    // each time the player chooses a piece type
    // override
    public CellGroup.MarkType getNextMarker(Player player){
        String [] markers = {"O", "X"};
        Menu menu = new Menu("Please enter your marker.");
        menu.addOption(markers[0]);
        menu.addOption(markers[1]);
        menu.printMenu();
        int select = menu.selectOption();
        return types.get(select-1);
    }

    // check the game is over
    //  first check board is full
    //  then find pieces in a row
    public boolean isOver() {
        // the board is full of pieces
        if(board.isTaken()){ // the second player, Chaos win
            winner = players.get((firstPlayIndex+1)%2); // no winner
            return true;
        }
        // check order is winner
        CellGroup.MarkType marker = board.getMark();
        if(marker == CellGroup.MarkType.ZERO){
            return false;
        }
        winner = players.get(firstPlayIndex);
        return true;
    }
}
