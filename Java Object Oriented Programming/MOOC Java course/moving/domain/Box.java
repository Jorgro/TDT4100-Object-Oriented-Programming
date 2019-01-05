
package moving.domain;

import java.util.ArrayList;
import java.util.List;

public class Box implements Thing, Comparable<Thing> {

    private int capacity;
    private List<Thing> thingsInBox = new ArrayList<Thing>();

    public Box(int maximumCapacity) {
        this.capacity = maximumCapacity;
    }

    public boolean addThing(Thing thing) {
        if(getVolume() + thing.getVolume() <= capacity){
            this.thingsInBox.add(thing);
            return true;
        }
        return false;
    }

    @Override
    public int compareTo(Thing o) {
        return 0;
    }

    @Override
    public int getVolume() {
        int sum = 0;
        for (Thing thing : this.thingsInBox) {
            sum += thing.getVolume();
        }
        return sum;
    }

}