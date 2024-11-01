/**
 * SuperTicTac.java
 * The Super Cells can be accessed using the alphabetic characters A-F
 * A B C
 * D E F
 * G H I
 * If a winner appears on the sub board,
 * the pieces cannot be placed there
 */

public class SuperTicTacToe extends TTTGame{

    private char maxLetter;
    public SuperTicTacToe(){
        super();
        maxLetter = 'I';
    }

    // game description of Super Tic Tac Toe
    @Override
    public void printWelCome() {
        String message = "This is Super Tic Tac Toe.\n";
        message += "The Super Cells can be accessed using the alphabetic characters A, B, C\n";
        message += "A B C\n";
        message += "D E F\n";
        message += "G H I\n";
        message += "If a winner appears on the sub board, the pieces cannot be placed there.\n";
        System.out.println(message);
    }
    // determine sub board
    // select from A- I
    public int readCellPosition(){
        char c = 'a';
        while (true){
            c = Menu.readAChar("Please enter A-"+maxLetter+": ");
            if(c >= 'a' && c <= (maxLetter+32)){
                break;
            }
            System.out.print("Invalid. ");
        }
        return  (int)(c-'a');
    }

    // place a piece on the board
    // If a winner appears on the sub board,
    // the pieces cannot be placed there.
    public void playPiece(Player player){
        System.out.println("Hi, " + player.getName() + ":");
        CellGroup.MarkType marker = getNextMarker(player);
        Board sub = null;

        while(true){
            int index = readCellPosition();
            sub = (Board) board.getChildren(index);
            if(sub.getMark() == CellGroup.MarkType.ZERO){
                break;
            }
            String message = "The sub-board has a winner, you can't place there";
            System.out.println(message);
        }
        placeCell(sub, marker);
    }

    // ask user to input width and height for chess board
    public void configBoard(){
        String head = "choose board size";
        Menu menu = new Menu(head);
        menu.addOption("3*3");
        menu.addOption("4*4");
        menu.addOption("5*5");
        menu.printMenu();
        int select = menu.selectOption();
        int width = 3;
        int height = 3;
        switch (select){
            case 1:
                maxLetter = 'I';
                break;
            case 2:
                maxLetter = 'P';
                width = 4;
                height = 4;
                break;
            case 3:
                maxLetter = 'Y';
                width = 5;
                height = 5;
                break;
        }

        board = new Board(width, height);
    }

    // make 3*3 board as a cell
    // and add small board to group board.
    public void makeBoard(){
        int width = board.getColumns();
        int height = board.getRows();
        int size = width*height;

        for(int i = 0; i < size; i++){
            CellGroup cellBoard = new Board(width,height);
            fillBoard((Board) cellBoard);
            board.addCell(cellBoard);
        }
    }

    // tool method of string array
    // initial array
    public void initialStringArray(String[] array){
        for(int i = 0 ; i< array.length; i++){
            array[i] = "";
        }
    }
    // tool method of string array
    // add two string array
    public void addStringArray(String[] array1, String[] array2){
        for(int i = 0 ; i< array1.length; i++){
            array1[i] += array2[i] + " ";
        }
    }
    // tool method of string array
    // concat string array to one string
    public String stringArrayToString(String[] array){
        String str = "";
        for(int i = 0 ; i< array.length; i++){
            str += array[i] + "\n";
        }
        return  str;
    }

    // print board of super tic tac toe
    public void printBoard(){
        int cols = board.getColumns();
        int rows = board.getRows();
        String chess = "";
        for(int i = 0; i < rows; i++){
            String[] lines = new String[rows*2+1];
            initialStringArray(lines);
            for(int j = 0; j < cols; j++){
                int index = i*cols+j;
                Board sub = (Board)board.getChildren(index);
                String[] subLines = sub.toRowString();
                addStringArray(lines,subLines);
            }
            chess += stringArrayToString(lines);
        }
        System.out.println(chess);
    }

}
