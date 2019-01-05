package phone_search;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Register {

    private List<Person> persons;

    public Register() {
        this.persons = new ArrayList<Person>();
    }

    public void addPerson(String name) {
        this.persons.add(new Person(name));
    } 

    public Person searchPerson(String name) {
        for (Person person : this.persons) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;

    }

    public void addNumber(String name, String number) {
        searchPerson(name).addNumber(number);
    }

    public Set<String> searchPersonNumbers(String name) {
        return searchPerson(name).getPhoneNumbers();
    }

    public Person searchByNumber(String numberComparison) {
        for (Person person : this.persons) {
            for (String phoneNumber : person.getPhoneNumbers()) {
                if (phoneNumber.equals(numberComparison)) {
                    return person;
                }
            }
        }
        return null;
    }

    public List<Person> filteredSearch(String keyword) {
        List<Person> persons = new ArrayList<Person>();

        for (Person person : this.persons) {
            if (person.getName().contains(keyword) || person.getAddress().contains(keyword)) {
                persons.add(person);
            }
        }

        return persons;
    }


}