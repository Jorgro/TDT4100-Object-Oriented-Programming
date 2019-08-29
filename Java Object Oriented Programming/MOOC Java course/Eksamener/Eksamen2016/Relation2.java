package Eksamener.Eksamen2016;

import java.util.ArrayList;
import java.util.Collection;

public class Relation2 implements Relation {

    private Relation rel1;
    private Relation rel2;

    public Relation2(Relation rel1, Relation rel2) {
        this.rel1 = rel1;
        this.rel2 = rel2;
    }

    @Override
    public Collection<Person> getRelativesOf(Person person) {
        Collection<Person> result = new ArrayList<>();

        Collection<Person> col1 = rel1.getRelativesOf(person);

        for (Person p : col1) {
            Collection<Person> col2 = rel2.getRelativesOf(p);
            col2.stream().forEach(c -> result.add(c));
        }

        if (result.contains(person)) {
            result.remove(person);
        }

        return result;

    }
}