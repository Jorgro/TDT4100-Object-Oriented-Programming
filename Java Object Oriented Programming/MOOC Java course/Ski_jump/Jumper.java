package Ski_jump;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Jumper implements Comparable<Jumper>{

    private String name;
    private int points;
    private ArrayList<Integer> lengths;
    private final Random random = new Random();

    public Jumper(String name) {
        this.name = name;
        this.points = 0;
        this.lengths = new ArrayList<Integer>();

    }
    
    @Override
    public int compareTo(Jumper jumper) {
        return this.points - jumper.getPoints();
    }

    public void addPoints(int number) {
        this.points += number;
    }

    public int[] jumpJudges() {
        int sum = 0;
        int[] judges = new int[5];
        for (int i = 0; i < 5; i++) {
            judges[i] = random.nextInt(11) + 10;
            sum += judges[i];
        }
        //Arrays.sort(judges);
        this.points += sum - Arrays.stream(judges).min().getAsInt()-Arrays.stream(judges).max().getAsInt();
        return judges;
    }


    public int jumpLength() {
        int length = random.nextInt(61) + 60;
        this.points += length;
        this.lengths.add(length);
        return length;
    }

    public String toString() {
        return this.name;
    }




    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the points
     */
    public int getPoints() {
        return points;
    }

    /**
     * @param points the points to set
     */
    public void setPoints(int points) {
        this.points = points;
    }

    /**
     * @return the lengths
     */
    public ArrayList<Integer> getLengths() {
        return lengths;
    }

    /**
     * @param lengths the lengths to set
     */
    public void setLengths(ArrayList<Integer> lengths) {
        this.lengths = lengths;
    }

    public static void main(String[] args) {
        Jumper mika = new Jumper("mika");
        int[] judges = mika.jumpJudges();
        System.out.println(Arrays.toString(judges));

    }

}