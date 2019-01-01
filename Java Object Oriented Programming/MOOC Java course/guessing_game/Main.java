package guessing_game;

public class Main {
	
	public static void main(String[] args) {
		GuessingGame game = new GuessingGame();

		// we play two rounds
		game.play(0,100);  // value to be guessed now within range 1-10
		//game.play(10,99);  // value to be guessed now within range 10-99
	}

}
