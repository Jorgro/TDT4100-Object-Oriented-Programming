package files;

import java.io.File;
import java.util.Scanner;

public class Printer {

    private File f;
    
    public Printer(String fileName) throws Exception{
        this.f = new File(fileName);

    }

    public void printLinesWhichContain(String word) throws Exception {
 
        Scanner reader = new Scanner(this.f, "UTF-8");

        while(reader.hasNext()) {
            String line = reader.nextLine();
            if (line.contains(word)) {
                System.out.println(line);
            }
        }
    }

    public static void main(String[] args) throws Exception{
        Printer printer = new Printer("MOOC Java course/files/textfile.txt");

        printer.printLinesWhichContain("Väinämöinen");
        System.out.println("-----");
        printer.printLinesWhichContain("Frank Zappa");
        System.out.println("-----");
        printer.printLinesWhichContain("");
        System.out.println("-----");
    }
}