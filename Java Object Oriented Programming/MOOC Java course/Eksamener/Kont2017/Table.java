package Eksamener.Kont2017;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Manages the set of ordered items for a table (set of guests).
 */
public class Table implements KitchenListener {

    private Kitchen kitchen;
    private final Menu menu;
    private Collection<MenuItem> orders = new ArrayList<>();

    /**
     * Initializes a new Table with a Menu that provides the prices for the Courses
     * and Meals
     * 
     * @param menu
     */
    public Table(Menu menu) {
        this.menu = menu;
    }

    public void addOrder(MenuItem item) {
        this.orders.add(item);
        if (kitchen != null)
            ;
        this.kitchen.menuItemAdded(this, item);

    }

    /**
     * Computes the total price for all the added items. Prices are provided by the
     * Menu.
     * 
     * @return the total price
     * @throws IllegalStateException when the price of an item cannot be provided by
     *                               the Menu
     */
    public double getPrice() throws IllegalStateException {
        double sum = 0;
        for (MenuItem order : orders) {
            sum += menu.getPrice(order);

        }
        return sum;

    }

    public void setKitchen(Kitchen kitchen) {
        if (this.kitchen != null) {
            this.kitchen.removeKitchenListener(this);
        }
        this.kitchen = kitchen;
        if (this.kitchen != null) {
            this.kitchen.addKitchenListener(this);
        }
    }

    public void courseReady(Table table, Course course) {

    }

}