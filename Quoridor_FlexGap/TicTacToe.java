/**
 * TicTacToe.java
 *
 * class of Tic Tac Toe
 * the board's shape can be rectangle
 */
public class TicTacToe extends TTTGame{

    public TicTacToe(){
        super();
    }

    // print game  description
    public void printWelCome(){
        String message = "This is Tic Tac Toe.\n";
        message += "the width of board is 3 - 9,";
        message += "the height of board is 3 - 9.\n";
        message += "The game chooses the smaller one between length and width";
        message += " as x.\nThe aim of players is to ";
        message += " get x like pieces in a row either vertically, horizontally, or diagonally.\n";
        System.out.println(message);
    }

    // ask user to input width and height for chess board
    public void configBoard(){
        System.out.print("Enter a width. ");
        int width = Menu.readInt(3,9);
        System.out.print("Enter a height. ");
        int height = Menu.readInt(3,9);
        board = new Board(width, height);

        int consecutive = board.getConsecutiveNumber();
        String message = "Tips: ";
        message += "who first gets "+consecutive+" pieces in a row is the winner.";
        System.out.println(message);
    }
}
