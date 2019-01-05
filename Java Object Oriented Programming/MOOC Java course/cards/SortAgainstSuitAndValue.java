package cards;

import java.util.Comparator;

public class SortAgainstSuitAndValue implements Comparator<Card> {

    public int compare(Card card1, Card card2) {
        if (card1.getSuit() - card2.getSuit() == 0) {
            return card1.getValue() - card2.getValue();
        }
        return card1.getSuit()-card2.getSuit();
    }
}