package rich_and_poor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Person implements Comparable<Person>{
    private String name;
    private int salary;

    public Person(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public int getSalary() {
        return this.salary;
    }

    public String getName() {
        return this.name;
    }

    @Override 
    public int compareTo(Person person) {
        //return this.salary - person.getSalary();

        return this.name.compareTo(person.getName());
    }


    public String toString() {
        return this.name + " tjener " + this.salary;
    }

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<Person>();

        persons.add(new Person("Jurgen", 29000));
        persons.add(new Person("Rasmus", 2000));
        persons.add(new Person("Alibaba", 20));
        System.out.println(persons);
        Collections.sort(persons);
        System.out.println(persons);
    }


}  