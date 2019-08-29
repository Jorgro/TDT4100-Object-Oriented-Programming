package Eksamener.Kont2016;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Person {

    private final String name;
    private Collection<Course> courses = new ArrayList<>();
    private Collection<Exam> exams = new ArrayList<>();

    public Person(String name) {
        this.name = name;
    }

    /**
     * Adds a Course to this Person, if no Course is registered for the same code,
     * year and semester.
     * 
     * @param course
     * @return true if the course was added, false otherwise
     */
    public boolean addCourse(Course course) {
        if (this.courses.stream()
                .anyMatch(c -> (c.getCode().equals(course.getCode()) && c.getTime().equals(course.getTime())))) {
            return false;
        }

        this.courses.add(course);
        return true;
    }

    /**
     * Returns whether this Person has a Course with the given code.
     * 
     * @param code
     */
    public boolean hasCourse(String code) {
        return (this.courses.stream().anyMatch(c -> (c.getCode().equals(code))));
    }

    /**
     * Creates and adds an exam to this Person for the provided Course and with the
     * provided grade, but only if this Person has this Course and no passing Exam
     * is registered for that Course.
     * 
     * @param course
     * @param grade
     * @return the newly created and added Exam, or null
     */
    public Exam addExam(Course course, Grade grade) {
        if (this.exams.stream().anyMatch(c -> (c.getCourse().equals(course) && c.isPass()))) {
            return null;
        }
        Exam e = new Exam(grade, course);
        this.exams.add(e);
        return e;
    }

    /**
     * Gets the exam that was registered last for the provided course code. This is
     * the exam that counts for that course!
     * 
     * @param course
     */
    public Exam getLastExam(String code) {
        List<Exam> rs = this.exams.stream().filter(c -> c.getCourse().getCode().equals(code))
                .collect(Collectors.toList());
        Collections.sort(rs);
        if (rs.size() != 0) {
            return rs.get(rs.size() - 1);
        }
        return null;
    }

    /**
     * Returns true of this Person has passed the Course for the provided code.
     * 
     * @param code
     */
    public boolean hasPassed(String code) {
        return this.exams.stream().filter(c -> c.getCourse().getCode().equals(code)).anyMatch(c -> c.isPass());
    }

    /**
     * Counts the credits this Person has earned.
     */
    public double countCredits() {
        double credits = 0.0;

        for (Course course : this.courses) {
            Exam e = getLastExam(course.getCode());
            if (e != null) {
                if (e.isPass()) {
                    credits += e.getCourse().getCredit();
                }
            }
        }
        return credits;
    }
}
