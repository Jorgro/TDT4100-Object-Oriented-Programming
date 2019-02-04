package reference;



public class Film {

    private String name;


    public Film(String name) {
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

        Film compared = (Film) o;

        if (this.name.equals(compared.getName())) {
            return false;
        }
        return true;

    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
}