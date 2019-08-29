package Eksamener.Eksamen2012;

public class DelegatingDayPlan extends DayPlan {

    public void addTimeSlot(DayPlan dp) {
        for (TimeSlot ts : dp.timeSlots) {
            super.addTimeSlot(ts);
        }
    }
}