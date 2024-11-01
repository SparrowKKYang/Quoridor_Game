/**
 * TurnGame.java
 *
 * turn based game interface
 * It's for all turn base game
 */
public interface TurnGame{
    // initial the game
    public abstract void initialGame();

    // one round game
    public abstract void oneRound();

    // add player to game
    public abstract void addPlayer(Player player);

    // get summary result
    public abstract String getSummaryResult();
}