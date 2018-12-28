package birdwatchers_database;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		Database Birds = new Database(reader);
		
		String input = "";
		while (!input.equals("Quit")) {
			System.out.print("? ");
			input = reader.nextLine();
			
			if (input.equals("Add")) {
				Birds.Add();
				
			}else if (input.equals("Observation")) {
				Birds.Observation();
			}else if (input.equals("Statistics")) {
				Birds.Statistics();
			}else if (input.equals("Show")) {
				Birds.Show();
			}
		}
	}

}
