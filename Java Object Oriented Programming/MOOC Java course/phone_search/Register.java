package phone_search;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Register {

    private List<Person> persons;
    private Set<String> usedPhoneNumbers;

    public Register() {
        this.persons = new ArrayList<Person>();
        this.usedPhoneNumbers = new HashSet<String>();
    }

    /* public void addPerson(String name) {
        this.persons.add(new Person(name));
    }  */

    public Person searchPerson(String name) {
        for (Person person : this.persons) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;

    }

    public void addNumber(String name, String number) {
        if (searchPerson(name) == null) {
            this.persons.add(new Person(name));
        }
        if (!this.usedPhoneNumbers.contains(number)){
            this.usedPhoneNumbers.add(number);
            searchPerson(name).addNumber(number);
        }

    }

    public void addAddress(String name, String street, String city) {
        String address = street + " " + city;
        if (searchPerson(name) == null) {
            this.persons.add(new Person(name));
        }

        searchPerson(name).addAddress(address);
        }


    public Set<String> searchPersonNumbers(String name) {
        if (!this.persons.contains(searchPerson(name))) {
            return null;
        }
        return searchPerson(name).getPhoneNumbers();
    }

    public String searchByNumber(String numberComparison) {
        for (Person person : this.persons) {
            for (String phoneNumber : person.getPhoneNumbers()) {
                if (phoneNumber.equals(numberComparison)) {
                    return person.getName();
                }
            }
        }
        return null;
    }

    public List<Person> filteredSearch(String keyword) {
        List<Person> persons = new ArrayList<Person>();

        for (Person person : this.persons) {
            if (person.getName().contains(keyword) || person.getAddresses().contains(keyword)) {
                persons.add(person);
            }
        }

        return persons;
    }

    public void remove(String name) {
        if (this.persons.contains(this.searchPerson(name))) {
            this.persons.remove(this.searchPerson(name));

        }

    }


}