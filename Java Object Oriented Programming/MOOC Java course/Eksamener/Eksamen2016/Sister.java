package Eksamener.Eksamen2016;

import java.util.ArrayList;
import java.util.Collection;

public class Sister implements Relation {

    @Override
    public Collection<Person> getRelativesOf(Person person) {
        Collection<Person> result = new ArrayList<>();
        Person father = person.getFather();
        Person mother = person.getMother();

        for (Person c : father) {
            if (c.getGender() == Gender.FEMALE) {
                result.add(c);
            }
        }

        for (Person c : mother) {
            if (c.getGender() == Gender.FEMALE) {
                result.add(c);
            }
        }
        if (person.getGender() == Gender.FEMALE)
            ;
        result.remove(person);

        return result;
    }

}