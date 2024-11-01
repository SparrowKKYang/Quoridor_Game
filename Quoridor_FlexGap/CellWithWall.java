/**
 * CellWithWall.java
 *
 * It extends from a cell with 4 walls
 */
public class CellWithWall extends Cell{
    private boolean upWall;
    private boolean downWall;
    private boolean leftWall;
    private boolean rightWall;

    public  CellWithWall(){
        super();
        resetWall();
    }

    public  CellWithWall(CellWithWall other){
        super();
        // get marker
        this.setMarker(other.getMarker());
        this.upWall = other.upWall();
        this.downWall = other.downWall();
        this.leftWall = other.leftWall();
        this.rightWall = other.rightWall();
    }

    public  CellWithWall(int index){
        super(index);
        resetWall();
    }

    public  CellWithWall(int index, int length){
        super(index, length);
        resetWall();
    }

    // initial all walls
    public void resetWall(){
        upWall = false;
        downWall = false;
        leftWall = false;
        rightWall = false;
    }

    public boolean downWall() {
        return downWall;
    }

    public boolean leftWall() {
        return leftWall;
    }

    public boolean upWall() {
        return upWall;
    }

    public boolean rightWall() {
        return rightWall;
    }

    // set down wall
    public void setDownWall() {
        this.downWall = true;
    }
    // set left wall
    public void setLeftWall() {
        this.leftWall = true;
    }
    // set up wall
    public void setUpWall() {
        this.upWall = true;
    }
    // set right wall
    public void setRightWall() {
        this.rightWall = true;
    }
}
