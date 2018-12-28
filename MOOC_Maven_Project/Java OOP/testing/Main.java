package testing;

import java.util.HashMap;

public class Main {
	
	public static void main(String[] args) {
		HashMap<String, String> nicknames = new HashMap<String, String>();
		nicknames.put("matti", "mage");
		nicknames.put("Jørgen", "kul");
		nicknames.put("Ingeborg", "rar");
		
		System.out.println(nicknames.get("Jørgen"));
	}
}
