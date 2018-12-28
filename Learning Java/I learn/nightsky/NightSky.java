package nightsky;
import java.util.Random;
public class NightSky {
	private double density;
	private int width;
	private int height;
	private int starsInLastPrint;
	
	
	public NightSky(double density) {
		this.density = density;
		this.width = 20;
		this.height = 10; 
		
				
	}
	public NightSky(int width, int height) {
		this.density = 0.1;
		this.width = width;
		this.height = height; 
		
				
	}
	public NightSky(double density, int width, int height) {
		this.density = density;
		this.width = width;
		this.height = height; 
		
				
	}
	public void printLine() {
		
		Random rand = new Random();
		int number = 0;
		
		for(int i = 0; i < width; i++) {
			number = (int) (this.density*100);
			number = rand.nextInt(number);
			if (number == 0) {
				System.out.print('*');
				this.starsInLastPrint++; 
			
			} else {
				System.out.print(' ');
			}
			
			
			
		}
	}
	public int starsInLastPrint() {
		return this.starsInLastPrint;
	}
	
	public void print() {
		this.starsInLastPrint = 0;
		for (int i = 0; i<height; i++) {
			this.printLine();
			System.out.println();
		}
	}
	
	
	
	

}
