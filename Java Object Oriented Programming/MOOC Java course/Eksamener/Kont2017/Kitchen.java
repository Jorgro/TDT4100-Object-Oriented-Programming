package Eksamener.Kont2017;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Manages a queue of courses to produce, based on what is requested by Tables.
 */
public class Kitchen {

    // for each Table that has requested Courses,
    // there is a Collection of the Courses that are yet to be made
    private Map<Table, Collection<Course>> courseQueue = new HashMap<Table, Collection<Course>>();
    private Collection<KitchenListener> listeners = new ArrayList<>();

    /**
     * Enqueues a Course in the production queue, that is part of the provided
     * Table.
     * 
     * @param table
     * @param course
     */
    private void produceCourse(Table table, Course course) {
        Collection<Course> courses = courseQueue.get(table);
        if (courses == null) {
            courses = new ArrayList<Course>();
        }
        courses.add(course);
        courseQueue.put(table, courses);
    }

    /**
     * Internal methods that must be called when a Course of a Table has been
     * produced. Notifies registered listeners about the event.
     * 
     * @param table
     * @param course
     */
    private void courseProduced(Table table, Course course) {
        Collection<Course> courses = courseQueue.get(table);
        courses.remove(course);
        fireCourseReady(table, course);

    }

    /**
     * Should be called when a MenuItem is added to a Table, so the corresponding
     * Courses can be produced.
     * 
     * @param table
     * @param item
     */
    public void menuItemAdded(Table table, MenuItem item) {
        if (item instanceof Meal) {
            for (Course course : (Meal) item) {
                this.courseQueue.get(table).add(course);
            }
        } else {
            this.courseQueue.get(table).add((Course) item);
        }
    }

    public void addKitchenListener(KitchenListener kl) {
        this.listeners.add(kl);
    }

    public void removeKitchenListener(KitchenListener kl) {
        this.listeners.remove(kl);
    }

    private void fireCourseReady(Table table, Course course) {
        this.listeners.stream().forEach(c -> c.courseReady(table, course));
    }

}