package Eksamener.Kont2018;

import java.util.Iterator;

public class DiceIterator implements Iterator<Integer> {

    Dice dice;
    int dieNum;

    public DiceIterator(Dice d) {
        this.dice = d;
    }

    @Override
    public boolean hasNext() {
        return dieNum < dice.getDieCount();
    }

    @Override
    public Integer next() {
        int d = dice.getDieValue(dieNum);
        dieNum++;
        return d;
    }

}