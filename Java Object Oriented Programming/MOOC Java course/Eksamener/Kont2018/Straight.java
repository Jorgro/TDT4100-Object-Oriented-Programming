package Eksamener.Kont2018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Implementation of DiceScorer that gives a specific score til a so-called
 * straight, which is when all values give a series of consecutive values, e.g.
 * 1, 2, 3. All the die values must be used, so with six dice, the only
 * possibility is 1, 2, 3, 4, 5, 6. With five dice, there are two possibilities,
 * 1, 2, 3, 4, 5 and 2, 3, 4, 5, 6.
 */
public class Straight implements DiceScorer {

    private final int score;

    /**
     * Initializes this Straight object with the specific score.
     * 
     * @param score
     */
    public Straight(int score) {
        this.score = score;
    }

    /**
     * Checks that all die values in the provided Dice form a series of consecutive
     * values. If this is the case returns a DiceScore object with a Dice with the
     * die values contributing to the score (necessarily all of them) and the
     * corresponding score.
     */
    @Override
    public DiceScore getScore(Dice dice) {
        boolean straight = false;
        int start = 0;
        for (int i = 0; i < dice.getDieCount(); i++) {
            if (dice.getDieValue(i) > 0) {
                straight = true;
                start = i;
                break;
            }
        }

        for (int i = start; i < dice.getDieCount() - 1; i++) {
            if (!(dice.getDieValue(i) + 1 == dice.getDieValue(i + 1))) {
                straight = false;
            }
        }
        return straight ? new DiceScore(dice, this.score) : null;
    }

    public static void main(String[] args) {
        Collection f = new ArrayList(Arrays.asList(1, 2, 3, 4));
        Dice k = new Dice(f.iterator());
        Straight s = new Straight(50);
        System.out.println(s.getScore(k).getScore());

    }
}