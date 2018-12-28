package character_string_changer;

public class Change {
	private char from;
	private char to;
	
	public Change(char from, char to) {
		this.from = from;
		this.to = to;
			
	}
	
	public String change(String characterString) {
		return characterString.replace(this.from, this.to);
	}
	
	public static void main(String[] args) {
		  String word = "carrot";
		  Change change1 = new Change('a', 'b');
		  word = change1.change(word);

		  System.out.println(word);

		  Change Change2 = new Change('r', 'x');
		  word = Change2.change(word);

		  System.out.println(word);
		        
	}
}
