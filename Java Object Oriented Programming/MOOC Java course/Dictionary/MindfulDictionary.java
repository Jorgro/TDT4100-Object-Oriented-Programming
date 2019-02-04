package Dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



public class MindfulDictionary {

    private Map<String, String> dictionary;
    private File file;

    public MindfulDictionary() {
        this.dictionary = new HashMap<String, String>();
        this.file = null;
    }

    public MindfulDictionary(String file) {
        this.dictionary = new HashMap<String, String>();
        this.file = new File(file);
    }

    public boolean load() {
        try {
            Scanner reader = new Scanner(this.file);

            return true;
        } catch (FileNotFoundException e) {
            return false;
        }


    }

    public void add(String word, String translation) {
        if (!(this.dictionary.containsKey(word) || this.dictionary.containsValue(translation))) {
            this.dictionary.put(word, translation);
        }
    }

    public String translate(String word) {
        if (this.dictionary.containsKey(word)) {
            return this.dictionary.get(word);
        } else if (this.dictionary.containsValue(word)) {
            for (String key : this.dictionary.keySet()) {
                if (this.dictionary.get(key).equals(word)) {
                    return key;
                }

            }
        }
        return null;
    }

    public void remove(String word) {
        if (this.dictionary.containsKey(word)) {
            this.dictionary.remove(word);
        } else if (this.dictionary.containsValue(word)) {
            for (String key : this.dictionary.keySet()) {
                if (this.dictionary.get(key).equals(word)) {
                    this.dictionary.remove(key);
                    break;
                }

            }
        }
    }

    public static void main(String[] args) {
        MindfulDictionary dict = new MindfulDictionary();
        dict.add("apina", "monkey");
        dict.add("banaani", "banana");
        dict.add("ohjelmointi", "programming");
        dict.remove("apina");
        dict.remove("banana");
        
        System.out.println( dict.translate("apina") );
        System.out.println( dict.translate("monkey") );
        System.out.println( dict.translate("banana") );
        System.out.println( dict.translate("banaani") );
        System.out.println( dict.translate("ohjelmointi") );
    }
}