package Eksamener.Kont2016;

import java.util.Comparator;

public class Exam implements Comparable<Exam> {

    private static final Comparator<Exam> gradeComparator = gradeComparator();

    private Grade grade;
    private final Course course;

    public Exam(Grade grade, Course course) {
        this.grade = grade;
        this.course = course;
    }

    public boolean isPass() {
        return grade != Grade.F;
    }

    public Course getCourse() {
        return this.course;
    }

    public Grade getGrade() {
        return this.grade;
    }

    @Override
    public int compareTo(Exam exam) {
        return this.course.compareTo(exam.course);
    }

    public static Comparator<Exam> gradeComparator() {
        Comparator<Exam> gradeComparator = (Exam c1, Exam c2) -> (c1.grade.value - c2.grade.value);
        return gradeComparator;
    }
}