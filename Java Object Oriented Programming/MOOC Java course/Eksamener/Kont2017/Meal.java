package Eksamener.Kont2017;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

/**
 * Represents a set of (pre-defined) Courses that are ordered as a whole
 */
public class Meal extends MenuItem implements Iterable<Course> {

    private Collection<Course> courses;

    public Meal(String name, String description, Course[] courses) {
        super(name, description);
        this.courses = Arrays.asList(courses);
    }

    public String getName() {
        return super.name;
    }

    public String getDescription() {
        return super.description;
    }

    public Iterator<Course> iterator() {
        return courses.iterator();
    }

    public Course findCourse(Predicate<Course> test) {
        return this.courses.stream().filter(test).findFirst().get();
    }
}
