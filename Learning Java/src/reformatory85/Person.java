package reformatory85;

public class Person {
	private int weight;
	private String name; 
	
	public Person(int weight, String name) {
		this.weight = weight;
		this.name = name;
				
	}
	public String toString() {
		return this.name + ", " + this.weight + "kg.";
		
	}
	public int getWeight() {
		return this.weight;
	}
	
	public void setWeight(int number) {
		this.weight = number;
	}
}
