package farm_simulator;

public class MilkingRobot {
    private BulkTank tank;

    public BulkTank getBulkTank() {
        return this.tank;
    }

    public void setBulkTank(BulkTank tank) {
        this.tank = tank;
    }

    public void milk(Milkable milkable) {
        if (this.tank == null) {
            throw new IllegalStateException("The MilkingRobot hasn't been installed.");
        }
        double taken = milkable.milk();
        this.tank.addToTank(taken);

    }

    public static void main(String[] args) {
        MilkingRobot milkingRobot = new MilkingRobot();
        Cow cow = new Cow();
        System.out.println("");

        BulkTank tank = new BulkTank();
        milkingRobot.setBulkTank(tank);
        System.out.println("Bulk tank: " + tank);

        for (int i = 0; i < 2; i++) {
            System.out.println(cow);
            System.out.println("Living..");
            for (int j = 0; j < 5; j++) {
                cow.liveHour();
            }
            System.out.println(cow);

            System.out.println("Milking...");
            milkingRobot.milk(cow);
            System.out.println("Bulk tank: " + tank);
            System.out.println("");
        }
    }
}