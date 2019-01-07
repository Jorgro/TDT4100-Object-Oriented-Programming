package farm_simulator;

import java.util.Random;

public class Cow implements Milkable, Alive {

    private static final String[] NAMES = new String[] { "Anu", "Arpa", "Essi", "Heluna", "Hely", "Hento", "Hilke",
            "Hilsu", "Hymy", "Ihq", "Ilme", "Ilo", "Jaana", "Jami", "Jatta", "Laku", "Liekki", "Mainikki", "Mella",
            "Mimmi", "Naatti", "Nina", "Nyytti", "Papu", "Pullukka", "Pulu", "Rima", "Soma", "Sylkki", "Valpu",
            "Virpi" };
    private String name;
    private double capacity;
    private double milk;
    private Random random = new Random();

    public Cow() {
        int indexName = random.nextInt(NAMES.length);
        this.name = NAMES[indexName];
        this.capacity = 15 + random.nextInt(26);
        this.milk = 0;
    }

    public Cow(String name) {
        this.name = name;
        this.capacity = 15 + random.nextInt(26);
        this.milk = 0;
    }

    @Override
    public void liveHour() {
        double produce = (random.nextInt(14) + 7.0)/10;
        if (this.milk + produce > this.capacity) {
            this.milk = this.capacity;
        } else {
            this.milk += produce;
        }
    }

    @Override
    public double milk() {
        double milk = this.milk;
        this.milk = 0;
        return milk;
    }

    @Override
    public String toString() {
        return this.name + " " + this.milk + "/" + this.capacity;
    }

    public static void main(String[] args) {
        Cow cow = new Cow();
        System.out.println(cow);

        Alive livingCow = cow;
        livingCow.liveHour();
        livingCow.liveHour();
        livingCow.liveHour();
        livingCow.liveHour();

        System.out.println(cow);

        Milkable milkingCow = cow;
        milkingCow.milk();

        System.out.println(cow);
        System.out.println("");

        cow = new Cow("Ammu");
        System.out.println(cow);
        cow.liveHour();
        cow.liveHour();
        System.out.println(cow);
        cow.milk();
        System.out.println(cow);
    }

    

}