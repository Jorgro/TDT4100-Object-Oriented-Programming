package thing_suitcase_container;

import java.util.ArrayList;

public class Container {
	
	private int weightLimit;
	private ArrayList<Suitcase> container;
	
	public Container(int weightLimit) {
		this.weightLimit = weightLimit;
		this.container = new ArrayList<Suitcase>();
	}
	
	public void addSuitcase(Suitcase suitcase) {
		if (this.totalWeight()+suitcase.totalWeight() <= this.weightLimit) {
			this.container.add(suitcase);
		}
		
	}
	
	public String toString() {
		return Integer.toString(this.container.size()) + " suitcases (" + Integer.toString(this.totalWeight()) + " kg)";
	}
	
	public int totalWeight() {
		int sum_ = 0;
		for (Suitcase suitcase : this.container) {
			sum_ += suitcase.totalWeight();
		}
		return sum_;
	}
	
	public void printThings() {
		for (Suitcase suitcase : this.container) {
			suitcase.printThings();
		}
	}
	
}
