/**
 * Player.java
 *
 *  player's class
 * before the game begins, the player get the piece type.
 */
public class Player {
    private String name;
    private int score;
    private CellGroup.MarkType currentPiece;
    private int position;
    private int wallCount;
    // constructor with a name
    public Player(){
        this.name = "";
        score = 0;
        position = -1;
        wallCount = 0;
    }

    public void setWallCount(int wallCount) {
        this.wallCount = wallCount;
    }

    public void reduceWallCount(){
        this.wallCount--;
    }

    public int getWallCount() {
        return wallCount;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setName(String name) {
        this.name = name;
    }

    // constructor with a name
    public Player(String name){
        this.name = name;
        score = 0;
    }
    // set piece type
    public void setCurrentPiece(CellGroup.MarkType currentPiece) {
        this.currentPiece = currentPiece;
    }
    // get piece type
    public CellGroup.MarkType getCurrentPiece() {
        return currentPiece;
    }
    // get player's score
    public int getScore() {
        return score;
    }
    // update player's score
    public void addScore(){
        score++;
    }
    // get player's name
    public String getName() {
        return name;
    }
}
