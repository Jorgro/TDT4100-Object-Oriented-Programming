
package Dungeon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Dungeon {

    private Player player;
    private List<Vampire> vampires;
    private Object[][] board;
    private Random random = new Random();
    private boolean vampiresMove;
    private Scanner scanner = new Scanner(System.in);
    private final Map<Character, int[]> getMovement = Map.of('s', new int[]{0, 1}, 'w', new int[]{0, -1},
     'a', new int[]{-1, 0}, 'd', new int[]{1, 0});

    public Dungeon(int length, int height, int vampires, int moves, boolean vampiresMove) {
        this.board = new Object[height][length];
        this.vampires = new ArrayList<Vampire>();

        while(countVampires() < vampires) {
            addVampire(length, height);
        }

        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[0].length; j++) {
                if (this.board[i][j] == null) {
                    this.board[i][j] = ".";
                }
            }
        }


        this.player = new Player(moves);
        this.board[0][0] = this.player;


        this.vampiresMove = vampiresMove;

    }


    public void addVampire(int length, int height) {
        int x = random.nextInt(length-1)+1; // +1 for å unngå initialisering på spillerens rute.
        int y = random.nextInt(height-1)+1;
        Vampire vamp = new Vampire(x, y);
        this.board[y][x] = vamp;
        this.vampires.add(vamp);
    }

    public int countVampires() {
        int counter = 0;
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[0].length; j++) {
                if (this.board[i][j] instanceof Vampire) {
                    counter ++;
                }
            }
        }
        return counter;
    }

    public void moveVampire(Vampire vampire) {
        List<int[]> moves = getLegalMoves(vampire);
        int[] pos = vampire.position();

        int index = random.nextInt(moves.size());
        int[] move = moves.get(index);
        int x = move[0];
        int y = move[1];

        if(x < 0 || x >= this.board[0].length || y < 0 || y >= this.board.length || (x - pos[0] == 0 && (y-pos[1] == 0))) {
            return;
        }

        this.board[y][x] = vampire;
        vampire.move(x-pos[0], y-pos[1]);
        //System.out.println(Arrays.toString(pos));
        //System.out.println(Arrays.toString(vampire.position()));
        this.board[pos[1]][pos[0]] = ".";

    }

    public void moveVampires() {

        for (Vampire vamp : this.vampires) { 

            moveVampire(vamp);
        }
        //System.out.println(this);
    }

    public void removeVampires() {
        List<Vampire> toBeRemoved = checkVampiresAroundPlayer();
        //System.out.println(toBeRemoved);
        this.vampires.removeAll(toBeRemoved);
        
    }

    public List<Vampire> checkVampiresAroundPlayer() {
        List<Vampire> toBeRemoved = new ArrayList<Vampire>();
        int[] playerPos = this.player.position();
        for(int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                try {
                    if (this.board[playerPos[1]+i][playerPos[0]+j] instanceof Vampire) {
                        Vampire remove = (Vampire) this.board[playerPos[1]+i][playerPos[0]+j];
                        toBeRemoved.add(remove);
                        this.board[playerPos[1]+i][playerPos[0]+j] = ".";
                    }
                } catch (Exception e) {

                }
            }
        }

        return toBeRemoved;
    }


    public List<int[]> getLegalMoves(Moveable moveable) { //kan hende jeg må skrive denne på nytt, virker som noe er galt.
        List<int[]> legalMoves = new ArrayList<int[]>();

        int[] pos = moveable.position();
        // går utenfor grensene til bordet.
        for (int i = -1; i < 2; i++) {
            try {
                if (!(pos[1]+i < 0 || pos[1]+i > this.board.length)) {
                    if (moveable instanceof Vampire) {
                        if (this.board[pos[1]+i][pos[0]].getClass() != moveable.getClass()) {
                            legalMoves.add(new int[]{pos[0], pos[1]+i});
                        }
                    } else {
                        legalMoves.add(new int[]{pos[0], pos[1]+i});
                    }
                } 
            } catch(Exception e) {

            }
        }

        for (int i = -1; i < 2; i++) {
            try {
                if (!(pos[0]+i < 0 || pos[0]+i > this.board[0].length)) {
                    if (moveable instanceof Vampire) {
                        if (this.board[pos[1]][pos[0]+i].getClass() != moveable.getClass()) {
                            legalMoves.add(new int[]{pos[0]+i, pos[1]});
                        }
                    } else {
                        legalMoves.add(new int[]{pos[0]+i, pos[1]});
                    }
                } 

            } catch(Exception e) {

            }
        }

        return legalMoves;
    }

    @Override
    public String toString() {
        String s = "";

        for (int i = 0; i < this.board.length; i++) {
            String k = "";
            for (int j = 0; j < this.board[0].length; j++){
                k += this.board[i][j].toString();
            }
            k += "\n";
            s += k;
        }
        return s;
    }


    public void turn() {
        String player = readPlayerMovement();


             for (int i = 0; i<player.length(); i++) {
                int[] move = getMovement.get(player.charAt(i));
                int[] pos = this.player.position();
                int[] newPos = {move[0]+pos[0], move[1]+pos[1]};
                List<int[]> moves = getLegalMoves(this.player);
                //System.out.println(moves);
                if(containsArray(moves, newPos)) {
                    this.board[pos[1]][pos[0]] = ".";
                    this.player.move(move[0], move[1]);
                    int[] afterMovement = this.player.position();
                    this.board[afterMovement[1]][afterMovement[0]] = this.player;
                    removeVampires();
                }
                if (this.vampiresMove) {
                    moveVampires();
                    removeVampires();
                }

             }
        }

    public boolean containsArray(List<int[]> collection, int[] array) {
        for (int[] arr : collection) {
            if (Arrays.equals(arr, array)) {
                return true;
            }
        }
        return false;
    }


    public String readPlayerMovement() {
        System.out.println("Movement:");
        String read  = this.scanner.nextLine();
        return read;
    }

    private void printPos() {
        int[] playerPos = this.player.position();
        System.out.println("@ " + playerPos[0] + " " + playerPos[1]);
        for (Vampire vamp : this.vampires) {
            int[] pos = vamp.position();
            System.out.println("v " + pos[0] + " " + pos[1]);
        }
    }

    public void run() {
        System.out.println("Welcome to the vampirehunter game!");

        while(true) {
            System.out.println(this.player.getMoves() + "\n");
            printPos();
            System.out.println(this);
            turn();
            this.player.removeBattery();
            if(this.vampires.size() == 0) {
                System.out.println(this);
                System.out.println("You won!");
                break;
            }

            if (this.player.getMoves() == 0) {
                System.out.println(this);
                System.out.println("You lost :(");
                break;
            }
        }

    }

    public static void main(String[] args) {
        Dungeon dung = new Dungeon(6, 7, 3, 10, false);
        dung.run();
    }   
}