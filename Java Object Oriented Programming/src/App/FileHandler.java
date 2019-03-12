package App;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class FileHandler implements FileManager {

    String fileName;    

    public FileHandler(String fileName){
        this.fileName = fileName;
    }

    @Override
    public void writeToFile(String text) throws Exception {
        FileWriter writer = new FileWriter(fileName);
        writer.write(text);
        writer.close();
    }

    @Override
    public String readFromFile() throws Exception{

        File file = new File(this.fileName);
        Scanner reader = new Scanner(file);
        String string = "";

        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            string += line;
            string += "\n";
        }

        reader.close();
        return string;
    }

    public boolean addNewHighScore(int score) throws Exception {
        String scores = readFromFile();
        String[] arrayScores = scores.split("\n");
        List<Integer> listScores = new ArrayList<Integer>();
        Arrays.stream(arrayScores).forEach(s -> listScores.add(Integer.parseInt(s)));
        //System.out.println(listScores);
        if (score <= listScores.get(0)) {
            return false;
        }

        Iterator<Integer> it = listScores.iterator();

        while (it.hasNext()) {
            int i = it.next();
            if (score <= i) {
                listScores.add(listScores.indexOf(i), score);
                listScores.remove(0);
                break;
            }
            if (!it.hasNext()) {
                listScores.add(score);
                listScores.remove(0);
            }

        }


        String streng = String.join("\n", listScores.stream().map(integer -> 
        integer.toString()).collect(Collectors.toList()));

        writeToFile(streng);
        return true;
        

    }
    public static void main(String[] args) throws Exception{
        FileHandler fl = new FileHandler("src/App/highscores.txt");
        System.out.println(fl.readFromFile());
        System.out.println("\n");
        System.out.println(fl.addNewHighScore(8000));
        System.out.println(fl.readFromFile());
    }

}