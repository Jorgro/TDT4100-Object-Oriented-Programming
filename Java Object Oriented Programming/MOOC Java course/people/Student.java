package people;

public class Student extends Person {

    private int credit;

    public Student(String name, String address) {
        super(name, address);
        this.credit = 0;
    }

    public void study() {
        this.credit ++;
    }
    
    public int credits() {
        return this.credit;
    }

    @Override
    public String toString() {
        return super.toString() + "\n credits " + this.credits();
    }


    public static void main(String[] args) {
        Student olli = new Student("Olli", "Ida Albergintie Street 1 00400 Helsinki");
        System.out.println( olli );
        olli.study();
        System.out.println( olli );
    }
}