package Eksamener.Kont2018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * Represents a set of die values.
 */
public class Dice implements Iterable<Integer> {
    /**
     * Counters for each possible die value. The counter at index i (0-5) is the
     * counter for the die value i+1 (1-6). I.e. the value at index 2 is the counter
     * for die value 3.
     */
    private final int[] valueCounters;

    /**
     * Initializes this Dice with the values in dieValues.
     * 
     * @param dieValues sequence of die values, not counter values
     */
    public Dice(Iterator<Integer> dieValues) {
        this.valueCounters = new int[] { 0, 0, 0, 0, 0, 0 };
        while (dieValues.hasNext()) {
            valueCounters[dieValues.next() - 1]++;
        }

    }

    /**
     * Initializes this Dice with the values in dieValues.
     * 
     * @param dieValues sequence of die values, not counter values
     */
    public Dice(Iterable<Integer> dieValues) {
        this(dieValues.iterator());
    }

    @Override
    public Iterator<Integer> iterator() {
        return new DiceIterator(this);
    }

    /**
     * @return the number of die values
     */
    public int getDieCount() {
        return Arrays.stream(valueCounters).sum();
    }

    /**
     * Die values are considered ordered, with the smallest die values at the lowest
     * index. The value at a specific index must be computed from the counters in
     * valueCounters.
     * 
     * @param dieNum
     * @return the value of die number dieNum
     * @throws an appropriate exception, if dieNum is out of range
     */
    public int getDieValue(int dieNum) {
        if (dieNum >= getDieCount()) {
            throw new IllegalArgumentException();
        }
        int a = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < valueCounters[i]; j++) {
                if (valueCounters[i] == 0) {
                    break;
                }

                if (dieNum == a) {
                    return i + 1;
                }
                a++;
            }
        }
        return 0;
    }

    /**
     * @param value
     * @return the number of dice with the provided value
     */
    public int getValueCount(int value) {
        return valueCounters[value - 1];
    }

    /**
     * @param dice
     * @return true if all die values in the Dice argument appear in this Dice
     */
    public boolean contains(Dice dice) {
        boolean contains = true;
        for (int i = 0; i < 6; i++) {
            if (!(this.valueCounters[i] >= dice.valueCounters[i]))
                ;
            contains = false;
        }
        return contains;
    }

    /**
     * @param dice
     * @return true if this Dice and the one provided have exactly the same die
     *         values
     */
    public boolean isSame(Dice dice) {
        boolean isSame = true;
        for (int i = 0; i < 6; i++) {
            if (!(this.valueCounters[i] == dice.valueCounters[i]))
                ;
            isSame = false;
        }
        return isSame;
    }

    /**
     * @param dice a Dice object
     * @return a new Dice instance with the all the die values in this Dice and the
     *         Dice argument combined
     */
    public Dice add(Dice dice) {
        Collection c = new ArrayList(Arrays.asList());
        Dice d = new Dice(c);
        for (int i = 0; i < 6; i++) {
            d.valueCounters[i] = this.valueCounters[i] + dice.valueCounters[i];
        }
        return d;
    }

    /**
     * @param dice
     * @return a new Dice instance with the die values from this Dice, but without
     *         those from the Dice argument
     */
    public Dice remove(Dice dice) {
        Collection c = new ArrayList(Arrays.asList());
        Dice d = new Dice(c);
        for (int i = 0; i < 6; i++) {
            d.valueCounters[i] = this.valueCounters[i] - dice.valueCounters[i];
            if (d.valueCounters[i] < 0) {
                d.valueCounters[i] = 0;
            }
        }
        return d;
    }

    public static void main(String[] args) {
        Collection c = new ArrayList(Arrays.asList(1, 1, 2, 3, 6));
        Dice d = new Dice(c.iterator());
        Collection f = new ArrayList(Arrays.asList(1, 1, 2, 3, 6));
        Dice k = new Dice(f.iterator());
        System.out.println(Arrays.toString(d.valueCounters));
        System.out.println(d.getDieCount());
        System.out.println(d.getDieValue(4));
        Dice l = d.remove(k);
        Dice p = d.add(k);
        System.out.println(Arrays.toString(l.valueCounters));
        System.out.println(Arrays.toString(p.valueCounters));

        for (int dieValue : d) {
            System.out.println(dieValue);
        }

        d.forEach(value -> System.out.println(value));
    }
}