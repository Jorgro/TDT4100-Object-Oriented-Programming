package phonebook_94;
import java.util.ArrayList;

public class Phonebook {
	
	private ArrayList<Person> persons;
	
	public Phonebook() {
		this.persons = new ArrayList<Person>();
	}
	
	public void add(String name, String number) {
		Person person = new Person(name, number);
		this.persons.add(person);
	}
	public void printAll() {
		for (Person person : this.persons) {
			System.out.println(person);
		}
	}
	
	public String searchNumber(String name) {
		for (Person person : this.persons) {
			if (person.getName().equals(name)) {
				return person.getNumber();
			}
		}
		return "Number not found";
	}

}
