package Eksamener.Eksamen2012;

import java.time.LocalTime;
import java.util.Date;

public class TimeSlot implements Comparable<TimeSlot> {

    private final int startHour;
    private final int startMinute;
    private final int duration;
    public final int endHour;
    public final int endMinute, totalStart, totalEnd;

    private final String descripription;

    public TimeSlot(String description, int hours, int minutes, int duration) {
        this.startHour = hours;
        this.startMinute = minutes;
        this.duration = duration;
        this.descripription = description;
        int durationHours = this.duration / 60;
        int durationMinutes = this.duration % 60;
        this.endHour = this.startHour + durationHours;
        this.endMinute = this.startMinute + durationMinutes;
        this.totalStart = hours * 60 + minutes;
        this.totalEnd = totalStart + duration;

    }

    public String toString() {

        return this.descripription + "@" + twoDigits(startHour) + ":" + twoDigits(startMinute) + "-"
                + twoDigits(endHour) + ":" + twoDigits(endMinute);
    }

    private String twoDigits(int i) {
        return (i < 10 ? "0" : "") + i;
    }

    public LocalTime getStartTime() {
        return LocalTime.of(this.startHour, this.startMinute);

    }

    public LocalTime getEndTime() {
        return LocalTime.of(endHour, endMinute);
    }

    public int getDuration() {
        return duration;
    }

    public boolean contains(int hours, int minutes) {
        if (hours < startHour || hours > endHour) {
            return false;
        } else if (hours == startHour && minutes <= startMinute) {
            return false;
        } else if (hours == endHour && minutes >= endMinute) {
            return false;
        }

        return true;
    }

    public boolean overlaps(TimeSlot timeSlot) {

        if (this.contains(timeSlot.startHour, timeSlot.startMinute)
                || this.contains(timeSlot.endHour, timeSlot.endMinute)) {
            return true;
        } else if (this.contains(timeSlot.startHour, timeSlot.startMinute + 1)) {
            return true;
        } else if (timeSlot.overlaps(this)) {
            return true;
        }

        return false;
    }

    @Override
    public int compareTo(TimeSlot o) {
        if (startHour != o.startHour) {
            return startHour - o.startHour;
        } else if (startMinute != o.startMinute) {
            return startMinute - o.startMinute;
        } else if (endHour != o.endHour) {
            return endHour - o.endHour;
        } else if (endMinute != o.endMinute) {
            return endMinute - o.endMinute;
        }
        return 0;
    }

}