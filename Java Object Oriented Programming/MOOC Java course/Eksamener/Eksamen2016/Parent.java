package Eksamener.Eksamen2016;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Parent implements Relation {

    @Override
    public Collection<Person> getRelativesOf(Person person) {
        Collection<Person> result = new ArrayList<>(Arrays.asList(person.getFather(), person.getMother()));
        return result;
    }
}