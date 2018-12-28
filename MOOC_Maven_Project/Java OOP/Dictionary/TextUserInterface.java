package Dictionary;

import java.util.Scanner;

public class TextUserInterface {

    private Scanner reader;
    private Dictionary dictionary;

    public TextUserInterface(Scanner reader, Dictionary dictionary) {
        this.reader = reader;
        this.dictionary = dictionary;
    }

    public void start() {

        System.out.println("Statement: ");
        System.out.println("quit - quit the userinterface");

        String userInput = "";
        String finnishWord = "";
        String translation = "";
        
        while (true) {
            System.out.println("Statement:");
            userInput = reader.nextLine();

            if (userInput.equals("quit")) {
                System.out.println("Cheers");
                break;

            } else if (userInput.equals("add")){
                 System.out.print("Finnish word: ");
                 finnishWord = reader.nextLine();
                 System.out.print("Translation: ");
                 translation = reader.nextLine();
                 this.dictionary.add(finnishWord, translation);
            } else if (userInput.equals("translation")) {
                System.out.print("Word to translate: ");
                translation = reader.nextLine();
                System.out.println("Translation: " + this.dictionary.translate((translation)));
            } else {
                System.out.println("Unknown command");
            
            }
        }
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Dictionary dict = new Dictionary();
    
        TextUserInterface ui = new TextUserInterface(reader, dict);
        ui.start();
    }
}

/* {
    "type": "java",
    "name": "CodeLens (Launch) - TextUserInterface",
    "request": "launch",
    "mainClass": "Dictionary.TextUserInterface",
    "projectName": "quickstart"
}, */
