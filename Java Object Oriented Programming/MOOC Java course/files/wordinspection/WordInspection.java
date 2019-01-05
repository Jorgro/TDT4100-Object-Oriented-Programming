package files.wordinspection;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class WordInspection {
    
    private File file;

    public WordInspection(File file) {
        this.file = file;
    }

    public int wordCount() throws Exception {
        Scanner reader = reader();
        int wordCount = 0;
        while(reader.hasNext()) {
            reader.next();
            wordCount ++;
        }

        return wordCount;

    }

    public List<String> wordsContainingZ() throws Exception{
        Scanner reader = reader();

        List<String> wordsContainingZ = new ArrayList<String>(); 

        while (reader.hasNext()) {

            String word = reader.next();
            if (word.contains("z") || word.contains("Z")) {
                wordsContainingZ.add(word);
            }
        }
        reader.close();
        return wordsContainingZ;
    }

    public List<String> wordsEndingInL() throws Exception{
        Scanner reader = reader();

        List<String> wordsEndingInL = new ArrayList<String>(); 

        while (reader.hasNext()) {

            String word = reader.next();
            if (word.charAt(word.length()-1) == 'l' || word.charAt(word.length()-1) == 'L') {
                wordsEndingInL.add(word);
            }
        }
        reader.close();
        return wordsEndingInL;
    }

    public List<String> palindromes() throws Exception {
        Scanner reader = reader();

        List<String> palindromes = new ArrayList<String>(); 


        while (reader.hasNext()) {
            String word = reader.next();
            if (word.equals(new StringBuilder(word).reverse().toString())) {
                palindromes.add(word);
            }
        }
        reader.close();
        return palindromes;
    }

    public List<String> wordsWhichContainAllVowels() throws Exception{
        String[] vowels = {"a", "e", "i", "o", "u", "y", "ä","ö"};
        Scanner reader = reader();

        List<String> wordsVowels = new ArrayList<String>(); 


        while (reader.hasNext()) {
            String word = reader.next();

            for (int i = 0; i < vowels.length; i++) {
                if (!word.contains(vowels[i])) {
                    break;
                } else if (i==vowels.length-1) {
                    wordsVowels.add(word);
                }
            }
        }
        reader.close();
        return wordsVowels;
    }

    private Scanner reader() throws Exception{
        return new Scanner(this.file, "UTF-8");
    }

    public static void main(String[] args) throws Exception{
        File f = new File("MOOC Java course/files/wordinspection/wordlist.txt");
        WordInspection inspect = new WordInspection(f);
        System.out.println(inspect.wordCount());
        System.out.println(inspect.wordsContainingZ());
        System.out.println(inspect.wordsEndingInL());
        System.out.println(inspect.palindromes());
        System.out.println(inspect.wordsWhichContainAllVowels());
    }
}