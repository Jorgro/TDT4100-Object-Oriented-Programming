package smileys;

public class Smileys {
	
	public static void main(String[] args) {
		printWithSmileys("\\:D/DDDD");
		printWithSmileys("87.");
		        
	}
	
	
	private static void printWithSmileys(String characterString) {
		
		if (characterString.length() % 2 == 0) {
			System.out.println(rowWithSmileys(3 + characterString.length()/2));
			System.out.println(":) " + characterString + " :)");
			System.out.println(rowWithSmileys(3 + characterString.length()/2));
		} else {
			characterString += " ";
			printWithSmileys(characterString);
		}
		
	}
	
	private static String rowWithSmileys(int number) {
		String smileys = "";
		for(int i = 0; i < number; i++) {
			smileys += ":)";
		}
		
		return smileys;
				
	}

}
