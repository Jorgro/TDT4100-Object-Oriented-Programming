package cards;

import java.util.HashMap;
import java.util.Map;

public class Card implements Comparable<Card> {
    public static final int SPADES  = 0;
    public static final int DIAMONDS  = 1;
    public static final int HEARTS = 2;
    public static final int CLUBS   = 3;
    private int value;
    private int suit;
    private final Map<Integer, String> suitToString = Card.setSuitToString();
    private final Map<Integer, String> valueToString = Card.setValueToString();

    public static Map<Integer, String> setSuitToString() {
        Map<Integer, String> suitToString = new HashMap<Integer, String>();
        suitToString.put(0, "Spades");
        suitToString.put(1, "Diamonds");
        suitToString.put(2, "Hearts");
        suitToString.put(3, "Clubs");
        return suitToString;
    }

    public static Map<Integer, String> setValueToString() {
        Map<Integer, String> valueToString = new HashMap<Integer, String>();
        valueToString.put(11, "J");
        valueToString.put(12, "Q");
        valueToString.put(13, "K");
        valueToString.put(14, "A");
        return valueToString;
    }


    

    public Card(int value, int suit) {
        this.value = value;
        this.suit = suit;
    }

    public String toString() {
        if (this.value < 11) {
            return this.value + " of " + this.suitToString.get(this.suit);
        }
        return this.valueToString.get(this.value) + " of " + suitToString.get(this.suit);
    }

    public int getValue() {
        return this.value;
    }


    public int getSuit() {
        return this.suit;
    }

    @Override
    public int compareTo(Card card) {
        if (this.value == card.getValue()) {
            return this.suit - card.getSuit();
        }
        return this.value - card.getValue();
    }

    public static void main(String[] args) {
        Card card = new Card(11, Card.SPADES);
        System.out.println(card);
    }

}