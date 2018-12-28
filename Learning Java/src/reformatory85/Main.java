package reformatory85;

public class Main {
	
	public static void main(String[] args) {
		Reformatory kongsvinger = new Reformatory();
		Person brian = new Person(85, "brian");
		Person pekka  = new Person(55, "pekka");
		
		System.out.println(brian);
		System.out.println(pekka);
		System.out.println(kongsvinger.weight(brian));
		System.out.println(kongsvinger.weight(brian));
		System.out.println(kongsvinger.weight(brian));
		System.out.println(kongsvinger.weight(brian));
		System.out.println(kongsvinger.weight(brian));
		System.out.println(kongsvinger.weight(brian));

		
		kongsvinger.feed(brian);
		kongsvinger.feed(brian);
		System.out.println(brian);
		System.out.println(kongsvinger.totalWeightsMeasured());
		
	}

}
