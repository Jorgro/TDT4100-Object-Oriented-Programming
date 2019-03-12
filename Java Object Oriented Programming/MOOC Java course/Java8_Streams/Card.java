package Java8_Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Card implements Predicate{

   private final char suit;
   private final int face;

   // initialises with suit ('S'=spade, 'H'=heart, 'D'=diamonds, 'C'=clubs) and
   // face (1=ace, 2, ... 10, 11=knight, 12=queen and 13=king).
   public Card(char suit, int face) {
      this.suit = suit;
      this.face = face;
   }

   @Override
   public String toString() {
      return String.format("%s%s", suit, face);
   }

   public char getSuit() {
      return suit;
   }

   public int getFace() {
      return face;
   }

   public static void main(String[] args) {
      Collection<Card> cards = Arrays.asList(new Card('C', 1), new Card('S', 2), new Card('D', 13), new Card('S', 13),
            new Card('S', 12), new Card('H', 2));
      List<Card> cards2 = new ArrayList<Card>();
      cards.stream().forEach(c -> cards2.add(c));
      //cards2.sort((c1, c2) -> c1.getFace().compareTo(c2.getFace()));


      cards.stream().filter(c -> (c.getSuit() == 'S')).forEach(c -> System.out.println(c));
      List<Card> hearts = cards.stream().filter(c -> c.getSuit() == 'H').collect(Collectors.toList());
      System.out.println(hearts.toString());
      List<Character> color = cards.stream().map(Card::getSuit).collect(Collectors.toList());
      System.out.println(color.toString());

      int i = cards.stream().map(Card::getFace).reduce((a, b) -> a + b).get();
      System.out.println(i);

      System.out.println(cards.stream().anyMatch(c -> (c.getSuit() == 'S' && c.getFace() == 12)));

      System.out.println(cards.stream()
            .allMatch(c -> (c.getSuit() == 'S' || c.getSuit() == 'H' || c.getSuit() == 'D' || c.getSuit() == 'C')));
      System.out.println(cards.stream().map(Card::getSuit).allMatch(c -> (cards.iterator().next().getSuit() == c)));

      System.out.println(cards.stream().map(Card::getSuit).distinct().count() == 4);
      String s = "hey man i am no";
      String k = "AG423205";
      String[] hey = s.split("");
      String[] hey2 = k.split("");
      cards.stream().forEach(System.out::println);
      boolean helo = Arrays.stream(hey).anyMatch(c -> (!"abcdefghijklkmnopqrstuvwxyz".contains(c)));

      boolean there = Arrays.stream(Arrays.copyOfRange(hey2, 2, hey2.length)).anyMatch(c -> (!"0123456789".contains(c)))
            && Arrays.stream(Arrays.copyOfRange(hey2, 0, 2))
                  .anyMatch(c -> (!"abcdefghijklkmnopqrstuvwxyz".contains(c)));

      System.out.println(helo);
      System.out.println(!there);
      System.out.println("Hello");
      System.out.println(cards.stream().anyMatch(find('G')));
      System.out.println(Card.getCard(cards));
   }

   @Override
   public boolean test(Object t) {
      Card c = (Card) t;

      return (c.getSuit() == 'S');
   }

   public static Predicate<Card> find(char s) {
      return c -> c.getSuit() == s;
   }

   public static Card getCard(Collection<Card> cards) {
      return cards.stream().filter(find('S')).findFirst().get();
   }
}