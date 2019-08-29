package Eksamener.Kont2016;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Course implements Comparable<Course> {

    private final String courseCode;
    private double credit;

    private int year;
    private char semester;

    public Course(String course) {
        this.courseCode = course;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public double getCredit() {
        return this.credit;
    }

    public String getCode() {
        return this.courseCode;
    }

    public int getYear() {
        return this.year;
    }

    public char getSemester() {
        return this.semester;
    }

    /**
     * Gets the time this Course is given, in the format <semester><year> E.g. if
     * the semester is 'S' and the year is 2016, it should return S2016.
     */
    public String getTime() {
        return Character.toString(this.semester) + this.year;
    }

    /**
     * Sets the time that this Course is taught. The format is the semester (char)
     * followed by the year. The year may be shortened to two digits; if it is below
     * 50 then 2000 should be added, otherwise 1900. E.g. S16 means Spring 2016,
     * while F86 means Fall 1986.
     * 
     * @param time The time in the format <semester><year>
     * @throws IllegalArgumentException if the format is incorrect
     */
    public void setTime(String time) {
        checkTime(time);
        this.semester = Character.toUpperCase(time.charAt(0));
        this.year = Integer.parseInt(time.substring(1));
    }

    public static void checkTime(String time) throws IllegalArgumentException {
        if (((Character.toUpperCase(time.charAt(0)) != 'S') && (Character.toUpperCase(time.charAt(0))) != 'F')
                || time.length() > 5) {
            throw new IllegalArgumentException();
        }

        Integer.parseInt(time.substring(1));
    }

    @Override
    public int compareTo(Course course) {
        if (this.year != course.year) {
            return this.year - course.year;
        }

        return course.semester - this.semester;
    }

    public boolean isSame(Course course) {
        if (course.getCode().equals(this.courseCode)) {
            return true;
        }
        return false;
    }
}