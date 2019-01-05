package Ski_jump;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Statistics {

    private ArrayList<Jumper> jumpers;
    private final Random random = new Random();

    public Statistics() {
        this.jumpers = new ArrayList<Jumper>();

    }

    public void addJumper(Jumper jumper) {
        this.jumpers.add(jumper);
    }

    public void sort() {
        Collections.sort(this.jumpers);
    }

    public void reverseSort() {
        Collections.sort(this.jumpers);
        Collections.reverse(this.jumpers);
    }

    public void round() {
        int points = 0;
        for (Jumper jumper : this.jumpers) {
            points = random.nextInt(10) + 10;
            jumper.addPoints(points);
        }
    }
 
}