package farm_simulator;

import java.util.Collection;
import java.util.LinkedList;

public class Barn {

    private BulkTank tank;
    private MilkingRobot robot;

    public Barn(BulkTank tank) {
        this.tank = tank;
    }

    public BulkTank getBulkTank() {
        return this.tank;
    }

    public void installMilkingRobot(MilkingRobot milkingRobot) {
        this.robot = milkingRobot;
        this.robot.setBulkTank(this.tank);
    }

    public void takeCareOf(Cow cow) {
        if (this.robot == null) {
            throw new IllegalStateException("No MilkingRobot installed");
        }

        this.robot.milk(cow);
    }

    public void takeCareOf(Collection<Cow> cows) {
        if (this.robot == null) {
            throw new IllegalStateException("No MilkingRobot installed");
        }

        for (Cow cow : cows) {
            this.robot.milk(cow);
        }
    }

    @Override
    public String toString() {
        return this.tank.getVolume() + "/" + this.tank.getCapacity();
    }

    public static void main(String[] args) {
        Barn barn = new Barn(new BulkTank());
        System.out.println("Barn: " + barn);

        MilkingRobot robot = new MilkingRobot();
        barn.installMilkingRobot(robot);

        Cow ammu = new Cow();
        ammu.liveHour();
        ammu.liveHour();

        barn.takeCareOf(ammu);
        System.out.println("Barn: " + barn);

        LinkedList<Cow> cowList = new LinkedList<Cow>();
        cowList.add(ammu);
        cowList.add(new Cow());

        for (Cow cow : cowList) {
            cow.liveHour();
            cow.liveHour();
        }

        barn.takeCareOf(cowList);
        System.out.println("Barn: " + barn);
    }
}