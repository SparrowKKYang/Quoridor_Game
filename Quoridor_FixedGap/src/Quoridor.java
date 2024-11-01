/**
 * Quoridor.java
 *
 */
public class Quoridor extends TTTGame{
    private int player1Position;
    private int player2Position;
    public enum Direction{
        NONE, UP, DOWN, LEFT, RIGHT;
    }
    public Quoridor(){
        super();
    }
    public void printWelCome(){
        String message = "Quoridor is played on a game board of 81 square spaces (9×9). Each\n" +
                "player is represented by a pawn which begins at the center space of\n" +
                "one edge of the board (in a two-player game, the pawns begin\n" +
                "opposite each other). The objective is to be the first player to move\n" +
                "their pawn to any space on the opposite side of the game board from\n" +
                "which it begins.\n";
        System.out.println(message);
    }

    // config the board size
    public void configBoard(){
        String head = "choose board size";
        Menu menu = new Menu(head);
        menu.addOption("9*9");
        menu.addOption("11*11");
        menu.printMenu();

        int select = menu.selectOption();
        switch (select){
            case 1:
                board = new BoardWithWall(9,9);
                break;
            case 2:
                board = new BoardWithWall(11,11);
                break;
        }

        player1Position = board.getColumns()/2;
        player2Position = board.getColumns()* (board.getRows()-1)+player1Position;
    }

    // determine player
    // and set each player's piece type
    public void determinePlayer(){
        super.determinePlayer();
    }

    // set the wall of edge cell
    // e.g 1-9 upwall is true
    // 73-74 down wall is true
    public void addWallToEdge(){
        // first row and last row
        int row1 = 0;
        int row2 = board.getRows()-1;
        for(int j = 0; j < board.getColumns(); j++) {
            int index1 = row1* board.getColumns() + j;
            int index2 = row2* board.getColumns() + j;
            CellWithWall cell = (CellWithWall)board.getChildren(index1);
            cell.setUpWall();
            cell = (CellWithWall)board.getChildren(index2);
            cell.setDownWall();
        }
        // first column and last column
        int column1 = 0;
        int column2 = board.getColumns()-1;
        for(int i = 0; i < board.getRows(); i++) {
            int index1 = i* board.getColumns() + column1;
            int index2 = i* board.getColumns() + column2;
            CellWithWall cell = (CellWithWall)board.getChildren(index1);
            cell.leftWall();
            cell = (CellWithWall)board.getChildren(index2);
            cell.setRightWall();
        }
    }
    // fill a board with index number
    public void fillBoard(Board board){
        int size = board.getColumns()*board.getRows();
        for(int i = 0; i < size; i++){
            CellGroup cell = new CellWithWall(i+1);
            board.addCell(cell);
        }
        addWallToEdge();
    }

    // initial board
    // and give information to player
    // include piece position and the numbers of walls
    public void initialBoard(){
        super.initialBoard();
        board.setCell(player1Position, CellGroup.MarkType.ONE);
        board.setCell(player2Position, CellGroup.MarkType.TWO);
        players.get(playerTurn).setPosition(player1Position);
        players.get((playerTurn+1)%2).setPosition(player2Position);

        int countWalls = board.getColumns()+1;
        for(Player player: players){
            player.setWallCount(countWalls);
        }
    }

    // determine a player and play a piece on the board
    public void playPiece(Player player){
        System.out.println("Hi, " + player.getName() + ":");
        String head = "Please choose your action";
        Menu menu = new Menu(head);
        menu.addOption("move a piece");
        menu.addOption("place a wall");
        menu.addOption("exit game");
        menu.printMenu();
        int select = menu.selectOption();
        switch (select){
            case 1:
                movePiece(player);
                break;
            case 2:
                if(player.getWallCount() > 0)
                    placeWall(player);
                else
                    System.out.println("You have no wall to place.");
                break;
            case 3:
                exitGame = true;
                break;
        }
    }

    // prompt to input direction for moving
    public  Direction getDirection(){
        String head = "you have 4 directions to choose";
        Menu menu = new Menu(head);
        menu.addOption("up");
        menu.addOption("down");
        menu.addOption("left");
        menu.addOption("right");
        menu.printMenu();
        int select = menu.selectOption();
        Direction direction = Direction.NONE;
        switch (select){
            case 1:
                direction = Direction.UP;
                break;
            case 2:
                direction = Direction.DOWN;
                break;
            case 3:
                direction = Direction.LEFT;
                break;
            case 4:
                direction = Direction.RIGHT;
                break;
        }
        return direction;
    }

    // take move action
    // if not valid move return false
    // if it's valid move, update board and player
    boolean takeMoveAction(Player player, Direction direction){
        BoardWithWall b = (BoardWithWall)board;
        int current = player.getPosition();
        int next = b.getMovePosition(current, direction);
        if(next == -1)
            return  false;

        player.setPosition(next);
        
        b.clearCell(current); // clear previous position of player
        b.setCell(next, player.getCurrentPiece()); // move to new place
        return  true;
    }
    // you have 4 directions to move
    public void movePiece(Player player){
        while (true){
            Direction direction = getDirection(); // user input direction
            if(takeMoveAction(player, direction))
                break;
            System.out.println("This move is invalid.");
        }
    }

    // user input a start position of a wall
    // the column is between 0 and columns-1
    // the row is between 0 and rows-1
    public int inputPosition(){
        System.out.print("Select a cell as the start position of wall (The wall take sapce of 2 cells' side, enter 0 to exit game). \n");
        int position = -1;
        BoardWithWall b = (BoardWithWall)board;
        while (true){
            position = getPosition();
            if(position == -1){
                exitGame = true;
                break;
            }
            // check start index is valid
            if(b.getIndexRow(position) != b.getRows()-1
            && b.getIndexColumn(position) != b.getColumns()-1){
                break;
            }
            System.out.print("You can't place here. ");
        }
        return position;
    }

    // place a wall on board
    public  void placeWall(Player player){
        while (true){
            // 1. input start position from left
            int start = inputPosition();
            if(start == -1)
                break;
            // 2. input position of wall
            System.out.print("\nInput direction for placing the wall on selected cell. ");
            Direction direction = getDirection();

            BoardWithWall b = (BoardWithWall)board;
            int indexHorizontal = -1;
            int indexVertical = -1;
            // 3. try set wall on horizontal or vertical
            switch (direction){
                case UP:
                    indexHorizontal = start;
                    break;
                case DOWN:
                    indexHorizontal = b.down(start);
                    break;
                case LEFT:
                    indexVertical = b.left(start);
                    break;
                case RIGHT:
                    indexVertical = start;
                    break;
            }
            boolean flag = false;
            // try to set horizontal wall
            if(indexHorizontal != -1 ){
                flag = trySetHorizontalWall(indexHorizontal);
            }
            // try to set vertical wall
            if(indexVertical != -1 ){
                flag = trySetVerticalWall(indexVertical);
            }
            if(flag){
                player.reduceWallCount();
                break;
            }
            System.out.println("You can't place here.");
        }
    }


    // check new wall is valid which is on the board
    public boolean isValidWall(BoardWithWall board){
        Player player1 = players.get(playerTurn);
        Player player2 = players.get((playerTurn+1)%2);
        // check influence on player1
        int index = player1.getPosition();
        int targetRow = board.getRows()-1;
        if(player1.getCurrentPiece() != CellGroup.MarkType.ONE){
            targetRow = 0;
        }
        boolean r1 = board.hasPath(index, targetRow);

        // check influence on player2
        int index2 = player2.getPosition();
        int targetRow2 = board.getRows()-1 - targetRow;
        boolean r2 = board.hasPath(index2, targetRow2);

        return r1 && r2;
    }

    // try to set horizontal wall
    public boolean trySetHorizontalWall(int index){
        BoardWithWall b = (BoardWithWall)board;
        BoardWithWall newB = b.getCopy(); // do some test on copy
        if(!newB.setHorizontalWall(index))
            return  false;

        if(!isValidWall(newB)){
            System.out.println("There's no way for opponent player.");
            return  false;
        }
            
        b.setHorizontalWall(index);
        return  true;
    }

    // try to set vertical wall
    public boolean trySetVerticalWall(int index){
        BoardWithWall b = (BoardWithWall)board;
        BoardWithWall newB = b.getCopy(); // do some test on copy
        if(!newB.setVerticalWall(index))
            return  false;

        if(!isValidWall(newB))
            return  false;
        b.setVerticalWall(index);
        return  true;
    }

    
    @Override
    public boolean isOver() {
        BoardWithWall b = (BoardWithWall)board;
        int firstRow = 0;
        int lastRow = board.getRows()-1;
        boolean r1 = b.findMarkFromRow(firstRow, CellGroup.MarkType.TWO);
        boolean r2 = b.findMarkFromRow(lastRow, CellGroup.MarkType.ONE);
        if(r1 || r2){
            winner = players.get((playerTurn+1)%2);
            return  true;
        }
        return false;
    }
}
