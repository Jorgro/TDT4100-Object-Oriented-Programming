package Eksamener.Kont2018;

import java.util.Arrays;

import org.junit.Test;

public class testContains extends junit.framework.TestCase {

    @Test
    public void testContains() {
        assertFalse(new Dice(Arrays.asList(1, 2)).contains(new Dice(Arrays.asList(3))));
    }
}