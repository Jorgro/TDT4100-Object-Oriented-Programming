package Dungeon;

import java.util.Random;
//eneste oppgave er å holde orden på hvor den er. 
public class Vampire implements Moveable{

    private int x;
    private int y;
    private Random random = new Random();

    public Vampire(int x ,int y) { 
        this.x = x; 
        this.y = y;
    }
    //while løkke når vi initialiserer vampyrer for å få riktig antall (overlapp kan skje),
    // ha en countVampires() metode i dungeon


    @Override
    public void move(int x, int y) {
        this.x += x;
        this.y += y;
    }

    @Override
    public int[] position() {
        return new int[]{this.x, this.y};
    }

    @Override
    public String toString() {
        return "v";
    }

    public static void main(String[] args) {
        Dungeon dung = new Dungeon(10, 20, 3, 4, false);
        
    }

}