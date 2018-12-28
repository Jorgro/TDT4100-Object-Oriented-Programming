package birdwatchers_database;

import java.util.ArrayList;
import java.util.Scanner;

public class Database {
	private ArrayList<Bird> Birds;
	private int[] Stats;
	private Scanner reader;
	
	
	public Database(Scanner reader) {
		this.Birds = new ArrayList<Bird>();
		this.Stats = new int[100];
		this.reader = reader;
	}
	
	
	public void Add() {
		System.out.print("Name: ");
		String name = this.reader.nextLine();
		System.out.print("Latin Name: ");
		String latin_name = reader.nextLine();
		Bird bird = new Bird(name, latin_name);
		this.Birds.add(bird);
	}
	
	public boolean Observation() {
		System.out.print("What was observed? ");
		String name = this.reader.nextLine();
		for (Bird b : this.Birds) {
			if (b.name().equals(name)| b.latin_name().equals(name)) {
				this.Stats[this.Birds.indexOf(b)] ++;
				return true;
			}
		}
		return false;
	}
	
	public void Show() {
		System.out.print("What? ");
		String name = this.reader.nextLine();
		for (Bird b : this.Birds) {
			if (b.name().equals(name)| b.latin_name().equals(name)) { 
				System.out.println(b + ": " + this.Stats[this.Birds.indexOf(b)] + " observations.");
				break;
			}
		}
		
	}
	
	public void Statistics() {
		for (Bird b : this.Birds) {
			System.out.println(b + ": " + this.Stats[this.Birds.indexOf(b)] + " observations.");
		}
	}
	

	

}
