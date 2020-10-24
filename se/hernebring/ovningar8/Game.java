package se.hernebring.ovningar8;
public interface Game{
    String getName();
    /**
     * Play the game, return the player's score
     * @return the score
     */
    String play();
}