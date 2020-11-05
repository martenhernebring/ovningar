package se.hernebring.inlamning3;

/**A Piggy Bank model simulation with accepted values 1, 2, 5 & 10 and 0 to stop.
 * @author Mårten Hernebring @version 5
*/
public class Piggy {
    //private instance variables 
    private int coins;
    private int savings;

    /**Default empty Constructor with no coins and no savings */
    public Piggy() {
        this(0, 0);
    }

    /**Constructor with other coins and savings */
    public Piggy(int coins, int savings) {
        this.coins = coins;
        this.savings = savings;
    }

    //Private method for adding coins internally
    private void add(int coin){
        coins++;
        savings+= coin;
    }

    /**Method for saving coins (adds one for coins and value for savings) 
     * @param value of the coin entering the Piggy Bank
     * @return true if coin was entered successfully, null if zero was entered, false other*/
    public Boolean save(int value) {
        switch (value) {
            case 0: return null;
            case 1: add(1); return true;
            case 2: add(2); return true;
            case 5: add(5); return true;
            case 10: add(10); return true;
            default: return false;
        }
    }

    /**@return coins that was successfully entering the Piggy Bank */
    public int getCoins() {
        return coins;
    }

    /**@return savings total was successfully entering the Piggy Bank */
    public int getSavings() {
        return savings;
    }
}
