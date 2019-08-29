package Eksamener.Kont2018;

import java.util.List;

/**
 * Implementation of DiceScorer that gives a specific score when no other
 * DiceScore object applies. Requires that a certain number of dice have been
 * thrown.
 */
public class Nothing implements DiceScorer {

    private final int numDice;
    private final int score;
    private final DiceScorer[] diceScorers;

    /**
     * Initializes this Nothing object with the minimum required number of dice, the
     * specific score given and the other DiceScorer objects.
     * 
     * @param numDice     the min. number of dice required for this rule to apply
     * @param score       the specific score to give
     * @param diceScorers the (other) rules to check
     */
    public Nothing(int numDice, int score, DiceScorer... diceScorers) {
        this.numDice = numDice;
        this.score = score;
        this.diceScorers = diceScorers;
    }

    /**
     * Checks that no (other) DiceScore object apply, in case a specific score is
     * given.
     */
    @Override
    public DiceScore getScore(Dice dice) {
        if (this.numDice <= dice.getDieCount()) {
            for (int i = 0; i < diceScorers.length; i++) {
                DiceScore diceScore = diceScorers[i].getScore(dice);
                if (diceScore != null) {
                    return null;
                }
            }
        }

        return new DiceScore(dice, score);

    }
}