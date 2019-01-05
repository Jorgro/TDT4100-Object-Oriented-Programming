package moving.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Packer {
    private int boxesVolume;

    public Packer(int boxesVolume) {
        this.boxesVolume = boxesVolume;
    }

    public List<Box> packThings(List<Thing> things) {
        List<Box> boxes = new ArrayList<Box>();


        Collections.sort(things);

        boxes.add(new Box(this.boxesVolume));

        for (Thing thing : things) {
            for (Box box : boxes) {
                if (box.addThing(thing)) {
                    break;
                } else {
                    Box box1 = new Box(this.boxesVolume);
                    box1.addThing(thing);
                    boxes.add(box1);
                    break;
                }   
            }
        }
        return boxes;

/*         for (Box box : boxes) {
            while (i < things.size()) {
                if (!box.addThing(things.get(i))) {
                    System.out.println("Herro");
                    boxes.add(new Box(this.boxesVolume));

                    //break;
                } else {
                    System.out.println("Nice");
                    System.out.println(boxes);
                }
                i ++;
            }
        }
        return boxes; */

    }

    public static void main(String[] args) {
        // the things we want to pack
        List<Thing> things = new ArrayList<Thing>();
        things.add(new Item("passport", 2));
        things.add(new Item("toothbrash", 1));
        things.add(new Item("book", 4));
        things.add(new Item("circular saw", 8));

        // we create a packer which uses boxes whose valume is 10
        Packer packer = new Packer(10);

        // we ask our packer to pack things into boxes
        List<Box> boxes = packer.packThings(things);

        System.out.println("number of boxes: " + boxes.size());

        for (Box box : boxes) {
            System.out.println("  things in the box: " + box.getVolume() + " dm^3");
        }
    }
}