package hangman;

public class HangmanLogic {

    private String word;
    private String guessedLetters;
    private int numberOfFaults;

    public HangmanLogic(String word) {
        this.word = word.toUpperCase();
        this.guessedLetters = "";
        this.numberOfFaults = 0;
    }

    public int numberOfFaults() {
        return this.numberOfFaults;
    }

    public String guessedLetters() {
        return this.guessedLetters;
    }

    public int losingFaultAmount() {
        return 12;
    }

    public void guessLetter(String letter) {
        // program here the functionality for making a guess
    	if (this.guessedLetters.contains(letter)) {
    		return;
    	} else if (!this.word.contains(letter)){
    		this.numberOfFaults++;
    	}
    	this.guessedLetters += letter;
    	
    	

        // if the letter has already been guessed, nothing happens

        // it the word does not contains the guessed letter, the number of faults increases
        // the letter is added among the already guessed letters
    }

    public String hiddenWord() {
        // program here the functionality for building the hidden word
    	String hiddenWord = "";
    	int i = 0;
    	while (i < this.word.length()) {
    		if (this.guessedLetters.contains("" + this.word.charAt(i))) {
    			hiddenWord += "" + this.word.charAt(i);
    		} else {
    			hiddenWord += "_";
    		}
    		i ++; 
    	}

        // create the hidden word by iterating through this.word letter by letter
        // if the letter in turn is within the guessed words, put it in the hidden word
        // if the letter is not among the guessed ones, replace it with _ in the hidden word

        // return the hidden word at the end

        return hiddenWord;
    }
}