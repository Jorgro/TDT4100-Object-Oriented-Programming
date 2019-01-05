
package moving.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Item implements Thing, Comparable<Thing> {

    private int volume;
    private String name;

    public Item(String name, int volume) {

        this.volume = volume;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name + " (" + this.volume + " dm^3)";
    }

    @Override
    public int getVolume() {
        return this.volume;
    }


    public static void main(String[] args) {
        List<Item> items = new ArrayList<Item>();
        items.add(new Item("passport", 2));
        items.add(new Item("toothbrash", 1));
        items.add(new Item("circular saw", 100));
    
        Collections.sort(items);
        System.out.println(items);
    }

    @Override
    public int compareTo(Thing o) {
        return this.volume - o.getVolume();
    }
}