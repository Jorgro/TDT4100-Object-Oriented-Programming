package guessing_game;

import java.util.Scanner;

public class GuessingGame {

    private Scanner reader;

    public GuessingGame() {
        this.reader = new Scanner(System.in);
    }

    public void play(int lowerLimit, int upperLimit) {
        instructions(upperLimit, lowerLimit);
        String answer = "";
        int number = 0;
        while (lowerLimit != upperLimit-1) {
        	number = (int) Math.round((upperLimit+lowerLimit)*1.0/2);
        	System.out.println("Is your number greater than " + number + "? y/n");
        	answer = this.reader.nextLine();
        	if (answer.equals("y")) {
        		lowerLimit = number;
        	} else if (answer.equals("n")) {
        		upperLimit = number;
        	}
        	
        }
        
        System.out.println("Your number is " + upperLimit);
        
        
        // write the game logic here
    }

    // implement here the methods isGreaterThan and average

    public void instructions(int lowerLimit, int upperLimit) {
        int maxQuestions = howManyTimesHalvable(upperLimit - lowerLimit);

        System.out.println("Think of a number between " + lowerLimit + "..." + upperLimit + ".");

        System.out.println("I promise you that I can guess the number you are thinking of with " + maxQuestions + " questions.");
        System.out.println("");
        System.out.println("Next I'll present you with a series of questions. Answer them honestly.");
        System.out.println("");
    }

    // a helper method:
    public static int howManyTimesHalvable(int number) {
        // we create a base two logarithm  of the given value
        // Below we swap the base number to base two logarithms!
        return (int) (Math.log(number) / Math.log(2)) + 1;
    }
}
  