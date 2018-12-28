package grade_distribution;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;

public class Grades {
	private ArrayList<Integer> Grades;

	
	
	public Grades() {
		this.Grades = new ArrayList<Integer>();
	}
	
	public void addGrades(Scanner scanner) {
		int answer = 0;
		System.out.println("Type exam scores, -1 completes: ");
		while (answer != -1) {
			answer = Integer.parseInt(scanner.nextLine());
			if (answer >= 0 && answer <= 60) {
				this.Grades.add(answer);
			}
		}
	}
	
	public void printGrades() {
		System.out.println("Grade distribution:");
		Object[] array = this.Grades.toArray();
		Arrays.sort(array);
		//ArrayUtils.reverse(int[] array);
		for (int grade : this.Grades) {
			if (grade > 50) { 
				
			}
		}
	}
	

}
