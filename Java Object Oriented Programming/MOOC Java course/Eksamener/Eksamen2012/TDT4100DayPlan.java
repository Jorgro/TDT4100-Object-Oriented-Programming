package Eksamener.Eksamen2012;

public class TDT4100DayPlan extends DayPlan {

    private final TDT4100 tdt4100;

    public TDT4100DayPlan() {
        tdt4100 = new TDT4100();
        super.timeSlots.add(tdt4100);
    }

    @Override
    public void addTimeSlot(TimeSlot timeSlot) {
        if (timeSlot.overlaps(tdt4100)) {
            throw new IllegalArgumentException("Opptatt");
        }
        super.addTimeSlot(timeSlot);
    }

    @Override
    public void removeTimeSlot(TimeSlot timeSlot) {
        if (timeSlot.compareTo(tdt4100) == 0) {
            throw new IllegalArgumentException("Du må gå i TDT4100 forelesninger");
        }
        super.removeTimeSlot(timeSlot);
    }
}