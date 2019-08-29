package Eksamener.Eksamen2017;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class test {

    Diner diner;
    Table tab1, tab2;
    Seating seating;

    @Before
    public void setUp() throws Exception {
        this.diner = new Diner();
        this.tab1 = new SimpleTable(1);
        this.tab2 = new SimpleTable(3);
    }

    @Test
    public void testAddTable() {
        diner.addTable(tab1);
        diner.addTable(tab2);
        assertEquals(diner.findAvailableTables(1).iterator().next(), tab1);
    }

    @Test
    public void testOccupied() {
        diner.addSeating(new Group(2));
        assertEquals(diner.isOccupied(tab2), true);
    }


}