package Eksamener.Eksamen2018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Represents a set of die values. A die has six possible values 1-6, but the
 * number of dice may vary from Dice instance to Dice instance. In addition, a
 * Dice-instance can have a score.
 */
public class Dice implements Iterable<Integer> {


    private List<Integer> dieValues = new ArrayList<Integer>();
    private int score = -1;

    /**
    * @param dieCount
    * @return a collection of random integer values in the range 1-6
    */
    public static Collection<Integer> randomDieValues(int dieCount) {
       Collection<Integer> dieValues = new ArrayList<Integer>();
       for (int i = 0; i < dieCount; i++) {
           dieValues.add((int)(Math.random() * 6 + 1));
       }
       return dieValues;
    }


    /** (part 1)
    * Initializes this Dice with the values in dieValues, and a score.
    * @param dieValues
    * @param score the score to set, may be -1 for yet unknown
    * @throws a suitable exception if the die values are outside the valid range
    */
    public Dice(Collection<Integer> dieValues, int score) {
        if (dieValues.stream().anyMatch(v -> (v < 1 || v > 6))) {
            throw new IllegalArgumentException("Verdier ikke lovlig for en terning.");
        }

       this.dieValues.addAll(dieValues);
       this.score = score;
    }

    /** (part 1)
    * Initializes this Dice with dieCount random values (using Math.random())
    * @param dieCount
    */
    public Dice(int dieCount) {
       this(randomDieValues(dieCount), -1);
    }

    /** (part 1)
    * Initializes this Dice with the values in dice, and a score
    * @param dieValues // Denne skulle vært bare "dice", ikke "dieValues"
    * @param score the score to set, may be -1 for yet unknown
    */
    public Dice(Dice dice, int score) {
       this(dice.dieValues, score);
    }

    /**
     * (part 2) Format: [die1, die2, ...] = score (score is omitted when < 0)
     */

     public String toString() {
         String s = this.dieValues.toString();
         if (score != -1) {
             s += " = " + this.score;
         }
         return s;
     }
     
    /** (part 2)
    * Parses a string using the toString format (see above) and
    * returns a corresponding Dice.
    * @param s
    * @return a new Dice instance initialized with die values and score from the String argument
    */
    public static Dice valueOf(String s) {
       int score  = -1;
       int scorePos = s.indexOf("=");
       if (scorePos >= 0) {
           score = Integer.valueOf(s.substring(scorePos+1).trim());
           s = s.substring(0, scorePos).trim();
       }

       if (s.startsWith("[") && s.endsWith("]")) {
           s = s.substring(1, s.length() -1);
       } else {
           throw new IllegalArgumentException("Illegal format");
       }

       String[] dieValueString = s.split(",");
       Collection<Integer> dieValues = new ArrayList<Integer>();
       Arrays.stream(dieValueString).
       forEach(c -> dieValues.add(Integer.valueOf(c.trim())));
       return new Dice(dieValues, score);
    }


    /** (part 3)
    * @return the number of die values
    */
    public int getDieCount() {
       return this.dieValues.size();
    }

    /** (part 3)
    * @param dieNum
    * @return the value of die number dieNum
    */
    public int getDieValue(int dieNum) {
       return this.dieValues.get(dieNum);
    }

    /** (part 3)
    * @param value
    * @return the number of dice with the provided value
    */
    public int getValueCount(int value) {
       return (int) this.dieValues.stream().filter(c -> c == value).count();
    }

    /** (part 4)
    * @return the current score
    */
    public int getScore() {
       return this.score;
    }

    /** (part 4)
    * Sets the score, but only if it isn't already set to a non-negative value
    * @param score
    * @throws a suitable exception if score already is set to a non-negative value
    */
    public void setScore(int score) {
       if (this.score < 0) {
        this.score = score;
       } else {
           throw new IllegalStateException("Already set");
       }
    }

    @Override
    public Iterator<Integer> iterator() {
        return this.dieValues.iterator();
    }



    /** (part 6) // Denne ble det ikke spurt om, og det var ikke meningen at den skulle implementeres, men den kunne brukes
    * @param dice
    * @return true if all die values in the argument appear in this Dice
    */
    public boolean contains(Dice dice) {
        return false;
    }

    /** (part 6)
    * @param dices a Collection of Dice // Denne linja var feil, det skulle være bare "dice a Dice"
    * @return a new Dice instance with the all the die values this Dice and
    * all Dice in the argument, without any specific order
    */
    public Dice add(Dice dice) {
        Collection<Integer> dieValues = new ArrayList<>();
        dice.dieValues.stream().forEach(c -> dieValues.add(c));
        this.dieValues.stream().forEach(c -> dieValues.add(c));
        return new Dice(dieValues, -1);
    }

    /** (part 6)
    * @param dice
    * @return a new Dice instance with the die values from this Dice, but
    * without those from the argument, without any specific order
    */
    public Dice remove(Dice dice) {
       List<Integer> dieValues = new ArrayList<>(this.dieValues);
        dice.dieValues.stream().forEach(c -> dieValues.remove(c));
        return new Dice(dieValues, -1);
    }

    public Collection<Integer> getDieValues() {
        return this.dieValues;
    }

    public static void main(String[] args) {
        Dice dice = new Dice(4);
        System.out.println(dice);
        Dice dice2 = new Dice(2);
        System.out.println(dice2);
        System.out.println(dice.remove(dice2));
    }
}

