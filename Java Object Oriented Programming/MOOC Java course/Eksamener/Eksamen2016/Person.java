package Eksamener.Eksamen2016;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Person implements Iterable<Person> {

    private final String name;
    private Gender gender = null;
    private Person father;
    private Person mother;
    private List<Person> children = new ArrayList<>();

    public Person(String name) {
        this.name = name;

    }

    public void setFather(Person p) {
        if (p.getGender() == gender.MALE) {
            this.father = p;
        }
    }

    public void setMother(Person p) {
        if (p.getGender() == gender.FEMALE) {
            this.mother = p;
        }
    }

    public Person getFather() {
        return this.father;
    }

    public Person getMother() {
        return this.mother;
    }

    public String getName() {
        return this.name;
    }

    public Gender getGender() {
        return this.gender;
    }

    public void setGender(Gender g) {
        this.gender = g;
    }

    /**
     * @return the number of children of this Person
     */
    public int getChildCount() {
        return this.children.size();
    }

    /**
     * @param child
     * @return if this Person has the provided Person as a child
     */
    public boolean hasChild(Person child) {
        return this.children.contains(child);
    }

    /**
     * Returns all children of this Person with the provided Gender. If gender is
     * null, all children are returned. Can be used to get all daughters or sons of
     * a person.
     * 
     * @param gender
     */
    public Collection<Person> getChildren(Gender gender) {
        List<Person> temp = this.children.stream().filter(c -> (c.getGender() == null || c.getGender() == gender))
                .collect(Collectors.toList());
        return temp;
    }

    /**
     * Adds the provided Person as a child of this Person. Also sets the child's
     * father or mother to this Person, depending on this Person's gender. To ensure
     * consistency, if the provided Person already has a parent of that gender, it
     * is removed as a child of that parent.
     * 
     * @param child
     */
    public void addChild(Person child) {
        if (this.gender == gender.MALE) {
            if (child.father != null) {
                child.father.children.remove(child);
            }
            child.father = this;
        } else if (this.gender == gender.FEMALE) {
            if (child.mother != null) {
                child.mother.children.remove(child);
            }
            child.mother = this;
        }

        children.add(child);
    }

    @Override
    public Iterator<Person> iterator() {
        return this.children.iterator();
    }
}
