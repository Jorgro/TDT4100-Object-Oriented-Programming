package files;

import java.io.File;
import java.util.Scanner;

public class Analysis {

    private File file;

    public Analysis(File file) {
        this.file = file;
    }

    public int lines() throws Exception{
        Scanner reader = new Scanner(this.file, "UTF-8");
        int lines = 0;
        while(reader.hasNextLine()) {
            lines ++;
            reader.nextLine();
        }
        reader.close();
        return lines;
    }

    public int characters() throws Exception {
        Scanner reader = new Scanner(this.file, "UTF-8");
        int characters = 0;
        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            characters += line.length() + 1;
        }
        reader.close();
        return characters;
    }

    public static void main(String[] args) throws Exception{
        File file = new File("MOOC Java course/files/testfile.txt");
        Analysis analysis = new Analysis(file);
        System.out.println("Lines: " + analysis.lines());
        System.out.println("Characters: " + analysis.characters());
    }


}