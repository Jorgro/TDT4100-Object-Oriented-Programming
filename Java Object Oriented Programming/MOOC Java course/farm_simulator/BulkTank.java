package farm_simulator;

public class BulkTank {

    private double capacity;
    private double volumeTakenUp;

    public BulkTank() {
        this.capacity = 2000;
        this.volumeTakenUp = 0;
    }

    public BulkTank(double capacity) {
        this.capacity = capacity;
        this.volumeTakenUp = 0;
    }

    public double getCapacity() {
        return this.capacity;
    }

    public double getVolume() {
        return this.volumeTakenUp;
    }

    public double howMuchFreeSpace() {
        return this.capacity - this.volumeTakenUp;
    }

    public void addToTank(double amount) {
        if (this.volumeTakenUp + amount < this.capacity) {
            this.volumeTakenUp += amount;
        } else {
            this.volumeTakenUp = this.capacity;
        }
    }

    public double getFromTank(double amount) {
        if (this.volumeTakenUp - amount > 0) {
            this.volumeTakenUp -= amount;
            return amount;
        } else {
            double taken = this.volumeTakenUp;
            this.volumeTakenUp = 0;
            return taken;
        }
    }

    @Override
    public String toString() {
        return Math.floor(this.volumeTakenUp) + "/" + Math.floor(this.capacity);
    }

    public static void main(String[] args) {
        BulkTank tank = new BulkTank();
        tank.getFromTank(100);
        tank.addToTank(25);
        tank.getFromTank(5);
        System.out.println(tank);

        tank = new BulkTank(50);
        tank.addToTank(100);
        System.out.println(tank);
    }
}