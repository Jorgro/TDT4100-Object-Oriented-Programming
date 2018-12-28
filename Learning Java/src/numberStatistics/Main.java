package numberStatistics;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		NumberStatistics stats = new NumberStatistics();
		NumberStatistics odd = new NumberStatistics();
		NumberStatistics even = new NumberStatistics();
		Scanner reader = new Scanner(System.in);

		
		//System.out.println("Amount: " + stats.amountofNumbers());
		//System.out.println("Sum: " + stats.sum());
		//System.out.println("Average: " + String.format("%.2f", stats.average()));
		int num = 0;
		System.out.println("Type numbers: ");
		while (num != -1) {
			num = Integer.parseInt(reader.nextLine());
			stats.addNumber(num);
			if (num%2 == 0) {
				even.addNumber(num);
			} else {
				odd.addNumber(num);
			}
		}
		System.out.println("sum: " + (stats.sum()+1));
		System.out.println("sum of even: " + even.sum());
		System.out.println("sum of odd: "+ (odd.sum()+1));
	}
}
