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

    public void SortAgainstSuit() {
        Collections.sort(this.cards, new SortAgainstSuit());
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
        Hand hand1 = new Hand();

        hand1.add( new Card(2, Card.SPADES) );
        hand1.add( new Card(14, Card.CLUBS) );
        hand1.add( new Card(12, Card.HEARTS) );
        hand1.add( new Card(2, Card.CLUBS) );
      
        Hand hand2 = new Hand();
      
        hand2.add( new Card(11, Card.DIAMONDS) );
        hand2.add( new Card(11, Card.CLUBS) );
        hand2.add( new Card(11, Card.HEARTS) );
      
        int comparison = hand1.compareTo(hand2);
      
        if ( comparison < 0 ) {
          System.out.println("the most valuable hand contains the cards");
          hand2.print();
        } else if ( comparison > 0 ){
          System.out.println("the most valuable hand contains the cards");
          hand1.print();
        } else {
          System.out.println("the hands are equally valuable");
        }
           
    }


}