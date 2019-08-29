package Eksamener.Kont2018;

import java.util.Arrays;

/**
 * Implementation of DiceScorer that gives a specific score til a specific die
 * value. In Farkle it is used for giving 50 to fives and 100 to ones.
 */
public class SingleValue implements DiceScorer {

    private int value;
    private int score;

    /**
     * Initializes this SingleValue object with the (die) value and the
     * corresponding score. In Farkle you will typically create two of these, with
     * new SingleValue(5, 50) and new SingleValue(1, 100)
     * 
     * @param value
     * @param score
     */
    public SingleValue(int value, int score) {
        this.value = value;
        this.score = score;
    }

    /**
     * Looks for at least one of the specific value and if found, returns a
     * DiceScore object with a Dice object with the value contributing to the score
     * and the corresponding score.
     */
    @Override
    public DiceScore getScore(Dice dice) {

        if (dice.getValueCount(value) > 0) {
            return new DiceScore(new Dice(Arrays.asList(value)), score);
        } else {
            return null;
        }

    }
}