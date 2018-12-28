package clock89;

import boundedCounter.BoundedCounter;

public class Clock {
	private BoundedCounter seconds;
	private BoundedCounter minutes;
	private BoundedCounter hours; 
	
	public Clock(int hoursAtBeginning, int minutesAtBeginning, int secondsAtBeginning) {
		this.seconds = new BoundedCounter(59);
		this.minutes = new BoundedCounter(59);
		this.hours = new BoundedCounter(23);
		
		this.seconds.setValue(secondsAtBeginning);
		this.minutes.setValue(minutesAtBeginning);
		this.hours.setValue(hoursAtBeginning);
	}
	public void tick() throws Exception {
		Thread.sleep(1000);
		this.seconds.next();
		
		if (this.seconds.getValue() == 0) {
			this.minutes.next();
			
			if (this.minutes.getValue() == 0) {
				this.hours.next();
			}
		}
	}
	public String toString() {
		return hours + ":" + minutes + ":" + seconds;
	}
}
