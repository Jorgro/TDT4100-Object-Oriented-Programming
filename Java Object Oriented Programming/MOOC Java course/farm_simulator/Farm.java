package farm_simulator;

import java.util.Collection;
import java.util.LinkedList;

public class Farm implements Alive {

    private Collection<Cow> cows;
    private String owner;
    private Barn barn;

    public Farm(String name, Barn barn) {
        this.owner = name;
        this.barn = barn;
        this.cows = new LinkedList<Cow>();
    }

    public void addCow(Cow cow) {
        this.cows.add(cow);
    }

    public void manageCows() {
        this.barn.takeCareOf(this.cows);
    }

    public String getOwner() {
        return this.owner;
    }

    @Override
    public void liveHour() {
        for (Cow cow : this.cows) {
            cow.liveHour();
        }
    }

    public void installMilkingRobot(MilkingRobot robot) {
        this.barn.installMilkingRobot(robot);
    }

    @Override
    public String toString() {
        String toString = "Farm owner: " + this.owner + "\nBarn bulk tank: " + this.barn.toString() + "\n";
        if (this.cows.isEmpty()) {
            toString += "No cows.";
        } else {
            toString += "Animals:\n";
            for (Cow cow : this.cows) {
                toString += "        " + cow.toString() + "\n";
            }

        }

        return toString.strip();
    }

    public static void main(String[] args) {
        Farm farm = new Farm("Esko", new Barn(new BulkTank()));
        MilkingRobot robot = new MilkingRobot();
        farm.installMilkingRobot(robot);
        
        farm.addCow(new Cow());
        farm.addCow(new Cow());
        farm.addCow(new Cow());
        
        
        farm.liveHour();
        farm.liveHour();
        
        farm.manageCows();
        
        System.out.println(farm);
    }

}