package Filemanaging;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager {


    public List<String> read(String filename) throws FileNotFoundException,IOException{
        List<String> contents = new ArrayList<String>();
        File file = new File(filename);
        Scanner read = new Scanner(file);

        while (read.hasNextLine()) {
            contents.add(read.nextLine());
        }
        read.close();
        return contents;

    }

    public void save(String file, String text) throws IOException{
        FileWriter writer = new FileWriter(file);
        writer.write(text);
        writer.close();
    }

    public void save(String file, List<String> texts) throws IOException{
        FileWriter writer = new FileWriter(file);
        String s = "";
        for (String text : texts) {
            s += text + "\n";
        }
        writer.write(s);
        writer.close();
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileManager f = new FileManager();
        List<String> hey = new ArrayList<String>();
        hey.add("hey");
        hey.add("man");
        f.save("MOOC Java course/Filemanaging/text.txt", hey);
    }
}