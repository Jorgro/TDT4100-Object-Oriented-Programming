package organisms;

import java.util.ArrayList;
import java.util.List;

public class Group implements Moveable {

    private List<Moveable> group;

    public Group() {
        this.group = new ArrayList<Moveable>();
    }

    public void addToGroup(Moveable moveable) {
        this.group.add(moveable);
    }

    @Override
    public String toString() {
        String string = "";
        for (int i = 0; i < this.group.size()-1; i++) {
            string += this.group.get(i)+"\n";
        }
        string += this.group.get(this.group.size()-1);
        return string;
    }

    @Override
    public void move(int dx, int dy) {
        for (Moveable moveable : this.group) {
            moveable.move(dx, dy);
        }
    }

    public static void main(String[] args) {
        Group group = new Group();
        group.addToGroup(new Organism(73, 56));
        group.addToGroup(new Organism(57, 66));
        group.addToGroup(new Organism(46, 52));
        group.addToGroup(new Organism(19, 107));
        group.move(5, 2);
        System.out.println(group);
    }

}