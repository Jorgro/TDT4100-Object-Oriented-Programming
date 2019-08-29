package Eksamener.Eksamen2017;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Diner {

    private Collection<Table> tables = new ArrayList<>();
    private Collection<Seating> seatings = new ArrayList<>();

    /**
     * Tells whether a Table is occupied.
     * 
     * @param table the Table to check
     * @return true if anyone is sitting at the provided Table
     */
    public boolean isOccupied(Table table) {
        return seatings.stream().anyMatch(c -> table.equals(c.getTable()));
    }

    /**
     * Computes the guest capacity, either the remaining (includeOccupied == false)
     * or total (includeOccupied == true).
     * 
     * @param includeOccupied controls whether to include tables that are occupied.
     * @return the guest capacity
     */
    public int getCapacity(boolean includeOccupied) {
        Collection<Integer> in = new ArrayList<>();
        in.add(5);
        for (int i = 0; i < 5; i++) {
            int k = i;

            in.stream().anyMatch(c -> c == k);
        }
        if (includeOccupied) {
            return this.tables.stream().mapToInt(Table::getNum).reduce((a, b) -> (a + b)).getAsInt();
        } else {
            return this.tables.stream().filter(c -> !isOccupied(c)).mapToInt(Table::getNum).sum();
        }

    }

    /**
     * Adds a table to this Diner
     * 
     * @param table
     */
    public void addTable(Table table) {
        tables.add(table);
    }

    /**
     * Removes a Table from this Diner. If the table is occupied an
     * IllegalArgumentException exception should be thrown.
     * 
     * @param table
     * @throws IllegalArgumentException
     */
    public void removeTable(Table table) {
        if (isOccupied(table)) {
            throw new IllegalArgumentException("Noen sitter der..");
        }
        tables.remove(table);
    }

    /**
     * Merges two tables, i.e. replaces two tables with one table. lostCapacity is
     * the difference between the old capacity and the new. This number is typically
     * positive, since seats are lost when moving two tables close to each other.
     * 
     * @param table1
     * @param table2
     * @param lostCapacity
     * @throws IllegalArgumentException if any of the tables are occupied
     */
    /*
     * public void mergeTables(Table table1, Table table2, int lostCapacity) { int
     * totalCap = table1.getNum() + table2.getNum() - lostCapacity;
     * removeTable(table1); removeTable(table2); addTable(new
     * SimpleTable(totalCap)); }
     */

    public void mergeTables(Table tab1, Table tab2, int lostCapacity) {
        removeTable(tab1);
        removeTable(tab2);
        addTable(new CompositeTable(tab1, tab2, lostCapacity));
    }

    /**
     * Splits a table into two, i.e. replaces one tables with two tables. The two
     * capacities are the capacities of the two new tables.
     * 
     * @param table
     * @param capacity1
     * @param capacity2
     * @throws IllegalArgumentException if the table is occupied
     */
    public void splitTable(Table table, int capacity1, int capacity2) {
        removeTable(table);
        addTable(new SimpleTable(capacity1));
        addTable(new SimpleTable(capacity1));
    }

    public void splitTable(CompositeTable tab) {
        removeTable(tab);
        addTable(tab.getTab1());
        addTable(tab.getTab2());
    }

    /**
     * Tells whether a table has the provided capacity, i.e. if that number of new
     * guests can be seated there. Note that a table cannot be shared among
     * different groups.
     * 
     * @param table
     * @param capacity
     * @return true of capacity number of guests can be seated here, false
     *         otherwise.
     */
    public boolean hasCapacity(Table table, int capacity) {
        if (isOccupied(table)) {
            return false;
        }
        // this.tables.stream().filter(c -> (!isOccupied(c) && c.getNum() >=
        // capacity)).mapToInt(Table::getNum).min();
        return table.getNum() >= capacity;
    }

    /**
     * Returns the tables that has the provided capacity. The tables should be
     * sorted with the one with the least capacity (but enough) first.
     * 
     * @param capacity
     * @return the tables that has the provided capacity
     */
    public Collection<Table> findAvailableTables(int capacity) {
        return this.tables.stream().filter(c -> hasCapacity(c, capacity))
                .sorted(Comparator.comparing(Table::getNum).reversed()).collect(Collectors.toList());
    }

    /**
     * Finds a suitable, existing table for the provided group, and creates (but
     * doesn't add) a corresponding Seating. The chosen table should be the one with
     * the least capacity.
     * 
     * @param group the group to be seated
     * @return the newly created Seating
     */
    public Seating createSeating(Group group) {
        Collection<Table> ledige = findAvailableTables(group.getGuestCount());
        if (!ledige.isEmpty()) {
            return null;
        }

        return new Seating(ledige.iterator().next(), group);
    }

    /**
     * Creates and adds a Seating for the provided group, using the createSeating
     * method.
     * 
     * @param group
     * @return true if a Seating was created and added, false otherwise.
     */
    public boolean addSeating(Group group) {
        Seating seating = createSeating(group);
        if (seating == null) {
            return false;
        }
        return true;
    }

    /**
     * Removes the seating for the provided table (number), if one exists
     * 
     * @param tableNum the number of the table to be removed
     */
    public void removeSeating(int tableNum) {
        Iterator<Seating> seat = seatings.iterator();
        while (seat.hasNext()) {
            Seating s = seat.next();
            if (tableNum == s.getTable().tableNumber()) {
                seatings.remove(s);
            }
        }
    }

    public static void main(String[] args) {
        System.out.print("hellogaykz".matches("[A-Za-z]*"));
    }

}