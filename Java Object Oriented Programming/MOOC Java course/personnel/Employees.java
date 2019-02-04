package personnel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Employees {


    private List<Person> employees;

    public Employees() {
        this.employees = new ArrayList<Person>();
    }

    public void add(Person person) {
        this.employees.add(person);
    }    //adds the parameter person to the employees

    public void add(List<Person> persons) {
        persons.stream().forEach(c -> this.employees.add(c));
    }//adds the parameter list of people to the employees

    public void print() {
        this.employees.stream().forEach(c -> System.out.println(c));
    } //prints all the employees

    public void print(Education education)  {
        this.employees.stream().filter(c -> (c.getEducation() == education)).forEach(c -> System.out.println(c));
    } //prints all the employees, who have the same education as the one specified as parameter

    public void fire(Education education) {
/*         Iterator<Person> it = this.employees.iterator();

        while(it.hasNext()) {
            if(it.next().getEducation() == education) {
                it.remove();
            }
         } */

        this.employees = this.employees.stream().filter(c -> (c.getEducation() != education)).collect(Collectors.toList());
        //Virker som de kan ha samme kompleksitet, men Collectors.toList() metoden kan gi den andre n^2 i motsetning til n. 
        
    }

    public static void main(String[] args) {
        Employees emp = new Employees();

        emp.add(new Person("Jørgen", Education.D));
        emp.add(new Person("Jørge", Education.M));
        emp.add(new Person("Jørg", Education.G));
        emp.add(new Person("Jør", Education.B));
        emp.add(new Person("Jø", Education.D));
        emp.fire(Education.G);
        emp.print();
        emp.print(Education.D);
    }


}