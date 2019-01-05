package exceptions;

public class Person  {
    private int age;
    private String name;

    public Person(int age, String name) {
        if (name.length() <= 0 || name.length() > 40) {
            throw new IllegalArgumentException("Name must be between 1-40 characters");
        } 

        if (age < 0 || age > 120) {
            throw new IllegalArgumentException("Age must be between 0 and 120");
        }

        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        Person person = new Person(119, "Arne");
    }
}