package Dungeon;

public class Player implements Moveable{

    private int x;
    private int y;
    private int moves;

    public Player(int moves) {
        this.x = 0;
        this.y = 0;
        this.moves = moves;
    }

    @Override
    public int[] position() {
        return new int[]{this.x, this.y};
    }

    @Override
    public void move(int x, int y) {
        this.x += x;
        this.y += y;
    }

    public void removeBattery() {
        this.moves --;
    }

    public int getMoves() {
        return this.moves;
    }

    @Override
    public String toString() {
        return "@";
    }
    


}