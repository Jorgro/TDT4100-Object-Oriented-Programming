package Eksamener.Kont2018;

/**
 * Represents the score given to a set of die values
 */
public class DiceScore {

    private final Dice dice;
    private final int score;

    /**
     * Initialises a DiceScore object with the provided data
     * 
     * @param scoringDice the Dice object containing only the die values contibuting
     *                    to the score
     * @param score       the score itself
     */
    public DiceScore(Dice scoringDice, int score) {
        this.dice = scoringDice;
        this.score = score;
    }

    public int getScore() {
        return this.score;
    }

    public Dice getDice() {
        return this.dice;
    }
}