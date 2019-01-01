package thing_suitcase_container;

public class Thing {
	private String name;
	private int weight;
	
	public Thing(String name, int weight) {
		this.name = name;
		this.weight = weight;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getWeight() {
		return this.weight;
	}
	
	public String toString() {
		return this.name + " (" + Integer.toString(this.weight) + " kg)";
	}
	
}
