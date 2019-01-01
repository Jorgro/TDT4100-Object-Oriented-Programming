package toBeStored;

import java.util.ArrayList;

public class Box implements ToBeStored {
    private ArrayList<ToBeStored> items;
    private double capacity;

    public Box(double capacity) {
        this.items = new ArrayList<ToBeStored>();
        this.capacity = capacity; 
    }
    
    public double weight() {
        double weight = 0;
        for (ToBeStored item : this.items) {
            weight += item.weight();
        }

        return weight;
    }

    public void add(ToBeStored item) {
        if (this.weight() + item.weight() < this.capacity) {
            this.items.add(item);
        }
    }

    @Override
    public String toString() {
        return "Box: " + this.items.size() + " things, total weight " + this.weight() + " kg";
    }

    public static void main(String[] args) {
        Box box = new Box(10);

        box.add( new Book("Fedor Dostojevski", "Crime and Punishment", 2) ) ;
        box.add( new Book("Robert Martin", "Clean Code", 1) );
        box.add( new Book("Kent Beck", "Test Driven Development", 0.7) );

        box.add( new CD("Pink Floyd", "Dark Side of the Moon", 1973) );
        box.add( new CD("Wigwam", "Nuclear Nightclub", 1975) );
        box.add( new CD("Rendezvous Park", "Closer to Being Here", 2012) );

        System.out.println( box );

        Box box2 = new Box(40);
        //box2.add(box);
        //box2.add(box2);

        System.out.println(box2);

    }
} 