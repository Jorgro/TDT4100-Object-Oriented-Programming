package character_string_changer;

import java.util.ArrayList;

public class Changer {
	
	private ArrayList<Change> Changers;
	
	public Changer() {
		this.Changers = new ArrayList<Change>();
	}
	
	public void addChange(Change change) {
		this.Changers.add(change);
	}
	
	public String change(String characterString) {
		
		for (Change change : this.Changers) {
			characterString = change.change(characterString);
		}
		return characterString;
	}
	
	public static void main(String[] args) {
		  Changer scandiesAway = new Changer();
		  scandiesAway.addChange(new Change('ä', 'a'));
		  scandiesAway.addChange(new Change('ö', 'o'));
		  System.out.println(scandiesAway.change("ääliö älä lyö, ööliä läikkyy"));
	}

}
