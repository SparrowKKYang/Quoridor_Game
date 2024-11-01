import java.util.ArrayList;
import java.util.List;

/**
 * BoardWithWall inherits from Board
 *
 * BoardWithWall is for 'quoridor' for 9*9 or 11*11
 */
public class BoardWithWall extends Board{

    private List<Boolean> visited;
    public BoardWithWall(){
        super(9,9);
    }

    public BoardWithWall(int width, int height){
        super(width,height);
    }
    // return the string array.
    // each is a row representation of a board
    // and inner line with walls
    public String[] toRowString(){
        // first line and last line
        String line = generateSeparatorLine();
        String[] lines = new String[getRows()*2+1];

        int k = 0;
        lines[k++] = line;
        for(int i = 0; i < getRows(); i++){
            String rowString = "|";
            String innerWall = "";
            for (int j = 0; j < getColumns(); j++){
                int index = i*getColumns()+j;
                CellWithWall cell = (CellWithWall)getChildren(index);
                if(j < getColumns()-1 && cell.rightWall())
                        rowString += cell.toString() + "#";
                else
                    rowString += cell.toString() + "|";

                if(cell.downWall() && i < getRows()-1)
                    innerWall += "+###";
                else
                    innerWall += "+---";
            }
            //rowString += "|";
            innerWall += "+";
            lines[k++] = rowString;
            lines[k++] = innerWall;
        }
        return  lines;
    }

    public int getIndexRow(int index){
        return index / getColumns();
    }
    public int getIndexColumn(int index){
        return  index % getColumns();
    }
    // move horizontally
    public int moveHorizontal(int index, int offset){
        int target = -1;
        if(index == -1) return -1;
        int row = getIndexRow(index);
        int col = getIndexColumn(index);
        int i = col+offset;
        if(i >= 0 && i < getColumns()){
            target = row*getColumns()+i;
        }
        return  target;
    }
    // move vertically
    public  int moveVertical(int index, int offset){
        int target = -1;
        if(index == -1) return -1;
        int row = getIndexRow(index);
        int col = getIndexColumn(index);
        int j = row+offset;
        if(j >= 0 && j < getRows()){
            target = j*getColumns()+col;
        }
        return  target;
    }
    //get left position of index
    public int left(int index){
        return  moveHorizontal(index, -1);
    }
    // get right position of index
    public int right(int index){
        return  moveHorizontal(index, 1);
    }

    public int up(int index){
        return moveVertical(index, -1);
    }

    public int down(int index){
        return moveVertical(index, 1);
    }

    // clear a piece on board
    // the new piece type is zero
    public void clearCell(int index){
        CellWithWall cell = (CellWithWall)cells.get(index);
        cell.setMarker(new Checker(index+1));
    }

    public boolean findMarkFromRow(int row, MarkType type){
        int start = row*getColumns();
        for(int i = 0; i < getColumns(); i++){
            MarkType marker = getChildren(start+i).getMark();
            if(marker == type)
                return true;
        }
        return false;
    }

    // return  a copy of board
    public BoardWithWall getCopy(){
        BoardWithWall b = new BoardWithWall(getColumns(),getRows());
        for (CellGroup cell: cells){
            CellGroup newCell = new CellWithWall((CellWithWall)cell);
            b.addCell(newCell);
        }
        return  b;
    }

    // place a vertical wall
    //    1#3
    //   --+--
    //    2#4
    public boolean setVerticalWall(int index){
        int index1 = index;
        int index2 = down(index1);
        int index3 = right(index1);
        int index4 = right(index2);

        CellWithWall c1 = (CellWithWall)getChildren(index1);
        CellWithWall c2 = (CellWithWall)getChildren(index2);
        CellWithWall c3 = (CellWithWall)getChildren(index3);
        CellWithWall c4 = (CellWithWall)getChildren(index4);
        if(c1.rightWall() || c2.rightWall() || c3.leftWall() || c4.leftWall())
            return  false;
        c1.setRightWall();
        c2.setRightWall();
        c3.setLeftWall();
        c4.setLeftWall();
        return  true;
    }

    // place a horizontal wall
    //    3|4
    //   ##+##
    //    1|2
    public boolean setHorizontalWall(int index){
        int index1 = index;
        int index2 = right(index1);
        int index3 = up(index1);
        int index4 = up(index2);
        CellWithWall c1 = (CellWithWall)getChildren(index1);
        CellWithWall c2 = (CellWithWall)getChildren(index2);
        CellWithWall c3 = (CellWithWall)getChildren(index3);
        CellWithWall c4 = (CellWithWall)getChildren(index4);
        if(c3.downWall() || c4.downWall() || c1.upWall() || c2.upWall())
            return  false;
        c1.setUpWall();
        c2.setUpWall();
        c3.setDownWall();
        c4.setDownWall();
        return  true;
    }

    // get next position of user' move
    public int getNextPosition(int position, Quoridor.Direction direction){
        int newPosition = -1;
        CellWithWall cell = (CellWithWall)getChildren(position);
        switch (direction){
            case UP:
                if(!cell.upWall())
                    newPosition = up(position);
                break;
            case DOWN:
                if(!cell.downWall())
                    newPosition = down(position);
                break;
            case LEFT:
                if(!cell.leftWall())
                    newPosition = left(position);
                break;
            case RIGHT:
                if(!cell.rightWall())
                    newPosition = right(position);
                break;
        }
        return newPosition;
    }
    // try to move a piece on a direction
    public int getMovePosition(int position, Quoridor.Direction direction){
        // first move, try walls
        int next = getNextPosition(position, direction);
        if(next == -1)
            return -1;
        // second move
        // Meet opponent and try to jump
        if(getChildren(next).getMark() != CellGroup.MarkType.ZERO){
            next = getNextPosition(next, direction);
        }
        return next;
    }
    // find a path from index to target row
    public boolean hasPath(int index, int targetRow){
        resetVisited();
        return hasPathRecursive(index, targetRow);
    }
    public boolean hasPathRecursive(int index, int targetRow){
        if(getIndexRow(index) == targetRow)
            return true;
        //1. go up
        int next = getNextPosition(index, Quoridor.Direction.UP);
        if(next != -1 && visited.get(index) == false){
            visited.set(index, true);
            if(hasPathRecursive(next, targetRow)) return true;
            visited.set(index, false);
        }
        //2. go down
        next = getNextPosition(index, Quoridor.Direction.DOWN);
        if(next != -1 && visited.get(index) == false){
            visited.set(index, true);
            if(hasPathRecursive(next, targetRow)) return true;
            visited.set(index, false);
        }
        //3. go left
        next = getNextPosition(index, Quoridor.Direction.LEFT);
        if(next != -1 && visited.get(index) == false){
            visited.set(index, true);
            if(hasPathRecursive(next, targetRow)) return true;
            visited.set(index, false);
        }
        //4. go right
        next = getNextPosition(index, Quoridor.Direction.RIGHT);
        if(next != -1 && visited.get(index) == false){
            visited.set(index, true);
            if(hasPathRecursive(next, targetRow)) return true;
            visited.set(index, false);
        }

        return  false;
    }

    public void resetVisited(){
        visited = new ArrayList<>();
        for(int i = 0; i < cells.size(); i++){
            visited.add(false);
        }
    }
}
