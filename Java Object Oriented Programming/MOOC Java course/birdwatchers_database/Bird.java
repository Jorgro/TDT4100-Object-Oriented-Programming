package birdwatchers_database;

public class Bird {
	private String name;
	private String latinName;
	private int ringingYear;
	
	public Bird(String name, String latin_name, int ringingYear) {
		this.name = name;
		this.latinName = latin_name;
		this.ringingYear = ringingYear;
	}
	
	public String name() {
		return this.name;
	}
	
	public String latinName() {
		return this.latinName;
	}

	public int ringingYear() {
		return this.ringingYear;
	}
	
	@Override
	public String toString() {
		return this.latinName + " (" + this.ringingYear + ")";
		
	}

	@Override
	public boolean equals(Object other) {
		if (other == null) {
			return false;
		} else if (other.getClass() == this.getClass()) {
			Bird compared = (Bird) other;
			if (this.latinName.equals(compared.latinName()) ){
				if (this.ringingYear == compared.ringingYear()) {
					return true;
				}
			}
		}
		return false;

	}

	@Override
	public int hashCode() {
		return this.ringingYear + this.latinName.hashCode();
	}

	public static void main(String[] args) {
		Bird bird1 = new Bird("Rose Starling", "Sturnus roseus", 2012);
		Bird bird2 = new Bird("Rose-Coloured Starling", "Sturnus roseus", 2012);
		Bird bird3 = new Bird("Hooded Crow", "Corvus corone cornix", 2012);
		Bird bird4 = new Bird("Rose-Coloured Pastor", "Sturnus roseus", 2000);
	
		System.out.println( bird1.equals(bird2));   // same Latin name and same observation year: they are the same bird
		System.out.println( bird1.equals(bird3));   // different Latin name: they are not the same bird
		System.out.println( bird1.equals(bird4));   // different observation year: not the same bird
		System.out.println( bird1.hashCode()==bird2.hashCode() );
	}
		

}
