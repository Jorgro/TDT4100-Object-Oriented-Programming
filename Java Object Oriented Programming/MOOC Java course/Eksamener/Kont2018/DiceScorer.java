package Eksamener.Kont2018;

/**
 * Interface for scoring rules, i.e. logic for computing a score for a subset of
 * dice in a Dice
 */
public interface DiceScorer {

    /**
     * Computes a score for (a subset of) the dice in the Dice argument. The
     * returned DiceScore object stores a Dice object with those die values that
     * contributed to the score and of course the score itself.
     * 
     * @param dice
     * @return The result of applying the rule to the provided Dice, or null of the
     *         rule doesn't apply.
     */
    DiceScore getScore(Dice dice);
}