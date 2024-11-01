/**
 * TTTGame.java
 *
 * base class of TTT game
 */

import java.util.ArrayList;
import java.util.List;


public class TTTGame implements TurnGame{
    protected Board board;
    protected List<Player> players;
    protected Player winner;
    protected int playerTurn;  // turn player
    protected boolean exitGame;

    public TTTGame(){
        players = new ArrayList<>();
        board = null;
        playerTurn = 0;
        winner = null;
        exitGame = false;
    }

    // 3*3 board
    public void printWelCome(){
        String message = "This is Tic Tac Toe";
        System.out.println(message);
    }

    // print a menu
    // determine who play first and return the index of player list
    public int getPlayerIndex(){
        String head = "Please Choose who play first.";
        Menu menu = new Menu(head);
        for(Player player: players){
            menu.addOption(player.getName());
        }
        menu.printMenu();
        int select = menu.selectOption();
        return select-1;
    }

    // determine player
    // and set each player's piece type
    public void determinePlayer(){
        playerTurn = getPlayerIndex();
        players.get(playerTurn).setCurrentPiece(CellGroup.MarkType.ONE);
        players.get((playerTurn+1)%2).setCurrentPiece(CellGroup.MarkType.TWO);
    }

    // print game description and
    // determine which player play first
    @Override
    public void initialGame() {
        printWelCome();
        determinePlayer();
    }

    // each time fetch a player to play
    public Player getNextPlayer(){
        Player player = players.get(playerTurn);
        playerTurn = (playerTurn + 1) % 2;
        return player;
    }

    // ask user input a position of the cell
    public int getPosition(){
        int size = board.getColumns()* board.getRows();
        return Menu.readInt(0,size)-1;
    }

    // get marker for one turn
    public CellGroup.MarkType getNextMarker(Player player){
        return player.getCurrentPiece();
    }

    // place a piece on the board
    public void placeCell(Board board, CellGroup.MarkType marker){
        System.out.print("Enter a position(enter 0 to exit game).");
        while (true){
            int position = getPosition();
            if(position == -1){
                exitGame = true;
                break;
            }
            if(board.setCell(position, marker)){
                break;
            }
             System.out.print("Invalid. ");
        }
    }

    // determine a player and play a piece on the board
    public void playPiece(Player player){
        System.out.println("Hi, " + player.getName() + ":");
        CellGroup.MarkType marker = getNextMarker(player);
        placeCell(board, marker);
    }

    // one round game loop
    @Override
    public void oneRound() {
        winner = null;
        exitGame = false;
        initialBoard();

        while (!isOver() && !exitGame){
            printBoard();
            Player player = getNextPlayer();
            playPiece(player);
        }
        // check quit midway
        if(!exitGame){
            printBoard();
            printWinner();
        }
    }

    // update winner's score
    // and print winner's message
    public void printWinner(){
        if(winner == null){
            System.out.println("Draw Game!");
            return;
        }
        winner.addScore();
        String message = "Congratulations "+winner.getName() +"!\n";
        message += "You are the winner!";
        System.out.println(message);
    }

    // config the board size
    public void configBoard(){
        board = new Board(3, 3);
    }

    // fill a board with index number
    public void fillBoard(Board board){
        int size = board.getColumns()*board.getRows();
        int positionLength = Integer.toString(size).length();
        for(int i = 0; i < size; i++){
            CellGroup cell = new Cell(i+1, positionLength);
            board.addCell(cell);
        }
    }

    // make a board before play
    public void makeBoard(){
        fillBoard(board);
    }

    // initial board before play
    public void initialBoard(){
        configBoard();
        makeBoard();
    }

    // print a board
    public void printBoard(){
        String chess = board.toString();
        System.out.println(chess);
    }

    // add a player to game
    @Override
    public void addPlayer(Player player) {
        players.add(player);
    }

    // get summary result of players
    @Override
    public String getSummaryResult() {
        String message = "Good job, guys!\n";
        for(Player player: players){
            message += String.format("Player %s gets %d points\n",
                    player.getName(),player.getScore());
        }
        message += "See you next time.";
        return message;
    }

    // check game is over
    // first find pieces in a row
    // if the board is full, it will be draw game
    public boolean isOver() {
        CellGroup.MarkType marker = board.getMark();
        for(Player player: players){
            if(marker == player.getCurrentPiece()){
                winner = player;
                return true;
            }
        }
        if(board.isTaken()){ // draw game
            winner = null; // no winner
            return true;
        }
        return false;
    }


}
