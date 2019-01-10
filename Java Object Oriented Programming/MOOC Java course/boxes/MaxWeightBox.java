package boxes;

import java.util.ArrayList;
import java.util.Collection;

public class MaxWeightBox extends Box {
    private int maxWeight;
    private Collection<Thing> items;

    public MaxWeightBox(int maxWeight) {
        this.maxWeight = maxWeight;
        this.items = new ArrayList<Thing>();
    }

    public int getWeight() {
        int sum = 0;
        for (Thing thing : this.items){
            sum += thing.getWeight();
        }
        return sum;
    }

    @Override
    public void add(Thing thing) {
        if (getWeight() + thing.getWeight() <= this.maxWeight) {
            this.items.add(thing);
        }

    }

    @Override
    public boolean isInTheBox(Thing thing) {
        return (this.items.contains(thing));
    }

    public static void main(String[] args) {
        MaxWeightBox coffeeBox = new MaxWeightBox(10);
        coffeeBox.add(new Thing("Saludo", 5));
        coffeeBox.add(new Thing("Pirkka", 5));
        coffeeBox.add(new Thing("Kopi Luwak", 5));

        System.out.println(coffeeBox.isInTheBox(new Thing("Saludo")));
        System.out.println(coffeeBox.isInTheBox(new Thing("Pirkka")));
        System.out.println(coffeeBox.isInTheBox(new Thing("Kopi Luwak")));
    }



}