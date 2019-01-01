package thing_suitcase_container;

import java.util.ArrayList;

public class Suitcase {
	private int weightLimit;
	private ArrayList<Thing> things;
	
	public Suitcase(int weightLimit) {
		this.weightLimit = weightLimit;
		this.things = new ArrayList<Thing>();
	}
	
	public void addThing(Thing thing) {
		if (thing.getWeight()+this.sumWeight() <= this.weightLimit) {
			this.things.add(thing);
		}
	}
	
	public String toString() {
		int sumWeight = this.sumWeight();
		if (this.things.size() == 0) {
			return "empty (0 kg)";
		} else if (this.things.size() == 1) {
			return Integer.toString(this.things.size()) + " thing (" + Integer.toString(sumWeight) + " kg)";
		}
		return Integer.toString(this.things.size()) + " things (" + Integer.toString(sumWeight) + " kg)";
	}
	
	public int sumWeight() {
		int sumWeight = 0;
		for (Thing thing : this.things) {
			sumWeight += thing.getWeight();
		}
		return sumWeight;
	}
	
	public void printThings() {
		//System.out.println("Your suitcase contains the following things: ");
		for (Thing thing : this.things) {
			System.out.println(thing);
		}
		
	}
	
	public int totalWeight() {
		return this.sumWeight();
	}
	
	public Thing heaviestThing() {
		if (this.things.size() == 0) {
			return null;
		}
		
		Thing heaviest = this.things.get(0);
		
		for (Thing thing : this.things) {
			if (thing.getWeight() > heaviest.getWeight()) {
				heaviest = thing;
			}
		}
		return heaviest;
	}
}
