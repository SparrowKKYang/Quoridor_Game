/**
 * Board.java
 *
 * this class represent a board for players.
 * The logical 2-dimensional data of the checkerboard is actually a one-dimensional list
 * The index of the position of the checkerboard is calculated using the following formula:
 * index = i*columns+j
 * i is the y-coordinate, j is x-coordinate
 */

import java.util.ArrayList;
import java.util.List;

public class Board implements CellGroup{
    private int columns;
    private int rows;
    private int consecutiveNumber;
    protected List<CellGroup> cells;

    public Board(){
        this(3,3);
    }
    // constructor with width and height
    public Board(int width, int height){
        columns = width;
        rows = height;
        cells = new ArrayList<>();
        // determine consecutive piece number
        // chooses the smaller one between length and width
        consecutiveNumber = width;
        if(consecutiveNumber > height){
            consecutiveNumber = height;
        }
    }
    // set columns
    public void setColumns(int columns) {
        this.columns = columns;
    }
    // get columns
    public int getColumns() {
        return columns;
    }
    // set rows
    public void setRows(int rows) {
        this.rows = rows;
    }
    // get rows
    public int getRows() {
        return rows;
    }
    // get consecutive piece number
    public int getConsecutiveNumber() {
        return consecutiveNumber;
    }
    // set consecutive piece number
    public void setConsecutiveNumber(int consecutiveNumber) {
        this.consecutiveNumber = consecutiveNumber;
    }
    // place piece on the board
    public boolean setCell(int index, MarkType type){
        CellGroup cell = getChildren(index);
        // if index is valid and the cell is not taken
        if(cell != null && cell.isTaken() == false){
            cell.setCell(index, type);
            return true;
        }
        return false;
    }
    // return a marker of a board
    // if there's a winner, then return winner's mark
    // or return 'MarkType.ZERO' means no winner
    @Override
    public MarkType getMark() {
        MarkType m = MarkType.ZERO;
        if((m = findHorizontal()) != MarkType.ZERO){
            return m;
        }
        if((m = findVertical()) != MarkType.ZERO){
            return m;
        }
        if((m = findDiagonalRight()) != MarkType.ZERO){
            return m;
        }
        if((m = findDiagonalLeft()) != MarkType.ZERO){
            return m;
        }
        return MarkType.ZERO;
    }
    //find horizontally consecutive marker in a row
    // return the marker type
    public MarkType findHorizontal(){
        for(int i = 0; i < rows; i++){

            int len = 1;
            for(int j = 0; j < columns-1; j++){
                int index = i*columns + j;
                MarkType a = cells.get(index).getMark();
                MarkType b = cells.get(index+1).getMark();
                if(a == b){
                    len += 1;
                    if(len == consecutiveNumber && a != MarkType.ZERO){
                        return a;
                    }
                }else{
                    len = 1;
                }
            }
        }
        return  MarkType.ZERO;
    }

    //find vertically consecutive marker in a row
    // return the marker type
    public MarkType findVertical(){
        for(int i = 0; i < columns; i++){

            int len = 1;
            for(int j = 0; j < rows-1; j++){
                int index = j*columns + i;
                MarkType a = cells.get(index).getMark();
                MarkType b = cells.get(index+columns).getMark();
                if(a == b){
                    len += 1;
                    if(len == consecutiveNumber && a != MarkType.ZERO){
                        return a;
                    }
                }else{
                    len = 1;
                }
            }
        }
        return  MarkType.ZERO;
    }

    //find right diagonally consecutive marker in a row
    // return the marker type
    public MarkType findDiagonalRight(){
        // find right part
        for(int i = 0; i <= columns-consecutiveNumber; i++){

            int len = 1;
            int col = i;
            for(int j = 0; j < rows-1 && col < columns-1; j++, col++){
                int index = j*columns + col;
                MarkType a = cells.get(index).getMark();
                MarkType b = cells.get(index+columns+1).getMark();
                if(a == b){
                    len += 1;
                    if(len == consecutiveNumber && a != MarkType.ZERO){
                        return a;
                    }
                }else{
                    len = 1;
                }
            }
        }
        // find left part
        for(int i = 0; i <= rows-consecutiveNumber; i++){

            int len = 1;
            int row = i;
            for(int j = 0; j < columns-1 && row < rows-1; j++, row++){
                int index = row*columns + j;
                MarkType a = cells.get(index).getMark();
                MarkType b = cells.get(index+columns+1).getMark();
                if(a == b){
                    len += 1;
                    if(len == consecutiveNumber && a != MarkType.ZERO){
                        return a;
                    }
                }else{
                    len = 1;
                }
            }
        }
        return  MarkType.ZERO;
    }

    // find left diagonally consecutive marker in a row
    // return the marker type
    public MarkType findDiagonalLeft(){
        // find from left part
        for(int i = consecutiveNumber; i < columns; i++){

            int len = 1;
            int col = i;
            for(int j = 0; j < rows-1 && col > 0; j++, col--){
                int index = j*columns + col;
                MarkType a = cells.get(index).getMark();
                MarkType b = cells.get(index+columns-1).getMark();
                if(a == b){
                    len += 1;
                    if(len == consecutiveNumber && a != MarkType.ZERO){
                        return a;
                    }
                }else{
                    len = 1;
                }
            }
        }
        // find right part
        for(int i = 0; i <= rows-consecutiveNumber; i++){

            int len = 1;
            int row = i;
            for(int j = columns-1; j > 0 && row < rows-1; j--, row++){
                int index = row*columns + j;
                MarkType a = cells.get(index).getMark();
                MarkType b = cells.get(index+columns-1).getMark();
                if(a == b){
                    len += 1;
                    if(len == consecutiveNumber && a != MarkType.ZERO){
                        return a;
                    }
                }else{
                    len = 1;
                }
            }
        }
        return  MarkType.ZERO;
    }

    //add cell to board
    public void addCell(CellGroup cell){
        cells.add(cell);
    }

    // check the board is full of pieces
    @Override
    public boolean isTaken() {
        for(CellGroup cell: cells){
            if(!cell.isTaken()){
                return false;
            }
        }
        return true;
    }
    // get a cell form a board
    // it checks the index is valid
    @Override
    public CellGroup getChildren(int index) {
        if(index < 0 || index >= cells.size()){
            return null;
        }
        return cells.get(index);
    }
    // get the string representation of a board
    public String toString(){
        String boardString = "";
        String[] lines = toRowString();

        for(String line: lines){
            boardString += line + '\n';
        }
        return  boardString;
    }
    // return a separator line
    // like "+--+--+--+--+--+--+"
    public String generateSeparatorLine(){
        String line = "+";

        for (int i = 0; i < columns; i++){
            line += "---+";
        }
        return line;
    }

    // return the string array.
    // each is a row representation of a board
    public String[] toRowString(){
        String line = generateSeparatorLine();
        String[] lines = new String[rows*2+1];

        int k = 0;
        for(int i = 0; i < rows; i++){
            lines[k++] = line;
            String rowString = "|";
            for (int j = 0; j < columns; j++){
                int index = i*columns+j;
                CellGroup cell = getChildren(index);
                rowString += cell.toString() + "|";
            }
            lines[k++] = rowString;
        }
        lines[k] = line;
        return  lines;
    }

}
