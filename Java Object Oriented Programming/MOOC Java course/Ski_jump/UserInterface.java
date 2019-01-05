package Ski_jump;

import java.util.*;

public class UserInterface {
    private int roundCounter;
    private ArrayList<Jumper> jumpers;
    private Scanner scanner = new Scanner(System.in);

    public UserInterface() {
        this.jumpers = new ArrayList<Jumper>();
        this.roundCounter = 1;

    }

    public void sort() {
        Collections.sort(this.jumpers);
    }

    public void reverseSort() {
        Collections.sort(this.jumpers);
        Collections.reverse(this.jumpers);
    }

    public void round() {
        Collections.sort(this.jumpers);
        printOrder();


        System.out.println("Results of round" + this.roundCounter);
        for (Jumper jumper : this.jumpers) {
            System.out.println("  " + jumper);
            int length = jumper.jumpLength();
            System.out.println("    length: " + length);
            int[] judges = jumper.jumpJudges();
            System.out.println("    judge votes: " + Arrays.toString(judges));

        }
        this.roundCounter ++;
    }

    public void printOrder() {
        System.out.println("Jumping order: ");
        int i = 1;   
        for (Jumper jumper: this.jumpers) {
            System.out.println("  " + i + ". " + jumper + "(" + jumper.getPoints() 
            +  " points)");
            i++;
        }
    }

    public void addJumpers() {
        
        System.out.println("Kumpula ski jumping week" + "\n" +
                        "Write the names of the participants one at a time; " +
                         "an empty string brings you to the jumping phase.");
        String name = "k";
        while (!name.equals("")) {
            System.out.print("   Participant name: ");
            name = scanner.nextLine();
            if (!name.equals("")) {
                this.jumpers.add(new Jumper(name));
            }
            
        } 
    }

    public void addRounds() {
        String jump = "";
        while(true) {
            System.out.print("Write \"jump\" to jump; otherwise you quit: ");
            jump = scanner.nextLine();
            if (jump.equals("jump")){
                round();

            } else {
                break;
            }
        }
    }

    public void printResults() {
        Collections.sort(this.jumpers);
        Collections.reverse(this.jumpers);

        System.out.println("Thanks\n\n" + "Tournament results:" + "\nPosition    Name");
        
        int place = 1;
        for (Jumper jumper: this.jumpers) {
            System.out.println(place + "           " + jumper + " (" + jumper.getPoints()
            + " points)\n" + "            " + "jump lengths: " + jumper.getLengths());
            place ++;
        }
    }

    public static void main(String[] args) {
        //System.out.println("Kumpula ski jumping week");
        UserInterface menu = new UserInterface();
        menu.addJumpers();
        menu.addRounds();
        menu.printResults();
    }

    

}
