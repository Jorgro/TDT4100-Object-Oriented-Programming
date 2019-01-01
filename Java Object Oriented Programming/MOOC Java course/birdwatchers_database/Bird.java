package birdwatchers_database;

public class Bird {
	private String name;
	private String latin_name;
	
	public Bird(String name, String latin_name) {
		this.name = name;
		this.latin_name = latin_name;
	}
	
	public String name() {
		return this.name;
	}
	
	public String latin_name() {
		return this.latin_name;
	}
	
	public String toString() {
		return this.name + " (" + this.latin_name + ")";
		
	}
		

}
