package Eksamener.Kont2017;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Manages the set of Courses and Meals offered and their prices.
 */
public class Menu {

    private Map<Course, Double> courses = new HashMap<Course, Double>();
    private Map<Meal, Double> meals = new HashMap<Meal, Double>();

    private Map<MenuItem, Double> items = new HashMap<MenuItem, Double>();

    /**
     * Gets the price for a Course.
     * 
     * @param course
     * @return the price
     * @throws IllegalArgumentException if this Menu doesn't include the provided
     *                                  Course
     */

    public double getPrice(MenuItem item) throws IllegalArgumentException {
        if (!this.items.keySet().contains(item)) {
            throw new IllegalArgumentException();
        }

        double sum = this.items.get(item);
        if (item instanceof Meal) {
            if (sum == 0.0) {
                Meal meal = (Meal) item;
                for (Course course : meal) {
                    sum += getPrice(course);
                }
            }
        }
        return sum;
    }

    public void updatePrice(MenuItem item, double price) {
        this.items.put(item, price);
    }

    /*
     * public double getPrice(Course course) throws IllegalArgumentException { if
     * (!this.courses.keySet().contains(course)) { throw new
     * IllegalArgumentException(); } return this.courses.get(course); }
     * 
     * /** Sets/changes the price of the provided Course.
     * 
     * @param course
     * 
     * @param price
     */
    /*
     * public void updatePrice(Course course, double price) {
     * this.courses.put(course, price); }
     */

    /**
     * Gets the price for a Meal. If the registered price is 0.0, the price is
     * computed as the sum of the prices of the Meal's courses.
     * 
     * @param meal
     * @return
     * @throws IllegalArgumentException if this Menu doesn't include the provided
     *                                  Meal, or if a price of a Course is needed,
     *                                  but is missing
     */
    /*
     * public double getPrice(Meal meal) throws IllegalArgumentException { if
     * (!this.meals.keySet().contains(meal)) { throw new IllegalArgumentException();
     * } double total = meals.get(meal); if (total == 0.0) { for (Course course :
     * meal) { total += getPrice(course); } } return total; }
     */
    /**
     * Sets/changes the price of the provided Meal.
     * 
     * @param meal
     * @param price
     */
    /*
     * public void updatePrice(Meal meal, double price) { this.meals.put(meal,
     * price); }
     */
}