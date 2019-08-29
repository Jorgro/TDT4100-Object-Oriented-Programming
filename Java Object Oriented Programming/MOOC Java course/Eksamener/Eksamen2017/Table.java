package Eksamener.Eksamen2017;

public abstract class Table {

    private static int tableNum = 1;
    private final int num;
    private final int capacity;

    protected Table(int capacity) {
        this.capacity = capacity;
        this.num = tableNum++;
    }

    public int getNum() {
        return this.capacity;
    }

    public int tableNumber() {
        return this.num;
    }
}