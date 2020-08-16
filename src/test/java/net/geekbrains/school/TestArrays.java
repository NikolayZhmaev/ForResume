package net.geekbrains;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestArrays {

    Arrays arrays = new Arrays();

    @Test
    public void testBalance (){

        assertTrue(arrays.balance(new int[]{1, 1, 1, 2, 1}));
        assertFalse(arrays.balance(new int[]{2, 1, 1, 2, 1}));
        assertTrue(arrays.balance(new int[]{10, 10}));
    }

    @Test
    public void testShifter () {

        assertArrayEquals(arrays.shifter(new int[]{1, 2, 3, 4, 5}, 1), new int[]{5, 1, 2, 3, 4});
        assertArrayEquals(arrays.shifter(new int[]{1, 2, 3, 4, 5}, 2), new int[]{4, 5, 1, 2, 3});
        assertArrayEquals(arrays.shifter(new int[]{1, 2, 3, 4, 5}, -2), new int[]{3, 4, 5, 1, 2});
    }


}
