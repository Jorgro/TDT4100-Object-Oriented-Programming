package student88;
import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
    	Scanner reader = new Scanner(System.in);
        ArrayList<Student> Students = new ArrayList<Student>();
        

        while (true) {
        	System.out.print("name: ");
        	String name = reader.nextLine();
        	System.out.print("studentnumber: ");
        	String studentid = reader.nextLine();
        	if (name.equals("") | studentid.equals("")) {
        		break;
        	}
        	//Student name = new Student(name, studentid);
        	Students.add(new Student(name, studentid));
        }
        System.out.println("Give a search term: ");
        String search = reader.nextLine();
        
        for (Student element: Students) {
        	if (element.getName().contains(search)) {
        		System.out.println(element);
        	}
        }
    }
}
