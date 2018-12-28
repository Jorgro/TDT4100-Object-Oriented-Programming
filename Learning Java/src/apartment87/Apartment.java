package apartment87;

public class Apartment {
    private int rooms;
    private int squareMeters;
    private int pricePerSquareMeter;

    public Apartment(int rooms, int squareMeters, int pricePerSquareMeter){
        this.rooms = rooms;
        this.squareMeters = squareMeters;
        this.pricePerSquareMeter = pricePerSquareMeter;
    }
    
    public boolean larger(Apartment compared) {
    	return this.squareMeters > compared.squareMeters;
    }
    
    public int priceDifference(Apartment compared) {
    	int diff = Math.abs(this.squareMeters * this.pricePerSquareMeter - compared.squareMeters * compared.pricePerSquareMeter);
    	return diff;
    }
    public boolean moreExpensiveThan(Apartment compared) {
    	return this.squareMeters*this.pricePerSquareMeter > compared.squareMeters*compared.pricePerSquareMeter;
    }
}
  

