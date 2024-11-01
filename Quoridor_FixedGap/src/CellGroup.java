/**
 * CellGroup.java
 *
 * this class is group interface for board and cell
 * So the board can contain sub board.
 */
public interface CellGroup {
    public enum MarkType{
        ZERO, ONE, TWO;
    }
    // get the mark of a cell.
    // If you get from a board, return the marker of winner
    public abstract MarkType getMark();

    // set a cell a type
    public abstract boolean setCell(int index, MarkType type);

    // return a cell
    public abstract CellGroup getChildren(int index);

    // check the cell is taken
    // if the board is full, it just returns true
    public abstract boolean isTaken();

}
