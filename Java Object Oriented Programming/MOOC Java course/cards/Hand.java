package cards;


import java.util.ArrayList;
import java.util.Collections;


public class Hand implements Comparable<Hand>{

    private ArrayList<Card> cards;

    public Hand() {
        this.cards = new ArrayList<Card>();    
    }

    public void add(Card card) {
        this.cards.add(card);
    }


    public void print() {
        for (Card card : this.cards) {
            System.out.println(card);
        }
    }

    public void sort() {
        Collections.sort(this.cards);
    }

    public void sortAgainstSuit() {
        Collections.sort(this.cards, new SortAgainstSuitAndValue());
    }

    @Override
    public int compareTo(Hand hand) {
        if (this.sumValues() - hand.sumValues() == 0) {
            return this.sumSuits() - hand.sumSuits();
        }
        return this.sumValues() - hand.sumValues();
    }

    public int sumValues() {
        int sum = 0;
        for (Card card : this.cards) {
            sum += card.getValue();
        }
        return sum;
    }

    public int sumSuits() {
        int sum = 0;
        for (Card card : this.cards) {
            sum += card.getSuit();
        }
        return sum;
    }


    public static void main(String[] args) {
        Hand hand = new Hand();

        hand.add( new Card(12, Card.HEARTS) );
        hand.add( new Card(4, Card.CLUBS) );
        hand.add( new Card(2, Card.DIAMONDS) );
        hand.add( new Card(14, Card.CLUBS) );
        hand.add( new Card(7, Card.HEARTS) );
        hand.add( new Card(2, Card.CLUBS) );
      
        hand.sortAgainstSuit();
      
        hand.print();
           
    }


}