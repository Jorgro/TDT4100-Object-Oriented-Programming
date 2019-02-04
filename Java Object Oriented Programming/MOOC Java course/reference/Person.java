package reference;

public class Person {

    private String name;

    public Person(String name) {
        this.name = name;
    }


    public String getName() {
        return this.name;
    }


    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (getClass() != o.getClass()) {
            return false;
        }

        Person compared = (Person) o;

        if (this.name.equals(compared.getName())) {
            return false;
        }
        return true;

    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    public static void main(String[] args) {
        Rating given = Rating.GOOD;
        System.out.println("Rating " + given + ", value " + given.getValue());
        given = Rating.NEUTRAL;
        System.out.println("Rating " + given + ", value " + given.getValue());
    }
}