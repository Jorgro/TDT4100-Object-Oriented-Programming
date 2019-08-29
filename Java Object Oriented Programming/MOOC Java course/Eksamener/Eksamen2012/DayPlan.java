package Eksamener.Eksamen2012;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class DayPlan {

    protected List<TimeSlot> timeSlots = new ArrayList<>();

    public void addTimeSlot(TimeSlot timeSlot) {
        this.timeSlots.add(timeSlot);
    }

    public void removeTimeSlot(TimeSlot timeSlot) {
        this.timeSlots.remove(timeSlot);
    }

    public TimeSlot getTimeSlotAt(int hours, int minutes) {

        if (this.timeSlots.stream().anyMatch(c -> c.contains(hours, minutes))) {
            return this.timeSlots.stream().filter(c -> c.contains(hours, minutes)).findAny().get();
        } else {
            return null;
        }
    }

    public boolean containsOverlapping() {
        Collections.sort(timeSlots);

        for (int i = 0; i < timeSlots.size() - 1; i++) {
            if (timeSlots.get(i).overlaps(timeSlots.get(i + 1))) {
                return true;
            }
        }
        return false;
    }

    public Collection<TimeSlot> getFreeTime() {
        Collections.sort(timeSlots);
        Collection<TimeSlot> freeTime = new ArrayList<>();

        for (int i = 0; i < timeSlots.size() - 1; i++) {
            if (!timeSlots.get(i).overlaps(timeSlots.get(i + 1))) {
                freeTime.add(new TimeSlot("sparetime", timeSlots.get(i).endHour, timeSlots.get(i).endMinute,
                        (timeSlots.get(i + 1).totalStart - timeSlots.get(i).totalEnd)));
            }
        }

        if (timeSlots.get(timeSlots.size() - 1).endHour != 24) {
            freeTime.add(new TimeSlot("sparetime", timeSlots.get(timeSlots.size() - 1).endHour,
                    timeSlots.get(timeSlots.size() - 1).endMinute,
                    24 * 60 - timeSlots.get(timeSlots.size() - 1).totalEnd));
        }
        return freeTime;
    }
}