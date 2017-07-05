package com.tw;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class FrancTest {
    @Test
    public void test_one_franc_equals_one_franc() throws Exception {
        assertEquals(Money.franc(1), Money.franc(1));
    }

    @Test
    public void test_one_franc_not_equals_one_franc() throws Exception {
        assertNotEquals(Money.franc(1), Money.franc(2));
    }

    @Test
    public void test_one_franc_times_two() throws Exception {
        Money oneFranc = Money.franc(1);
        assertEquals(Money.franc(2), oneFranc.times(2));
    }

    @Test
    public void test_one_franc_plus_one_franc() throws Exception {
        Money oneFranc = Money.franc(1);
        Money anotherFranc = Money.franc(1);
        assertEquals(Money.franc(2), oneFranc.plus(anotherFranc));
    }

    @Test
    public void test_multiple_addition_times() throws Exception {
        Money oneFranc = Money.franc(1);
        Money twoFranc = Money.franc(2);
        assertEquals(Money.franc(6), oneFranc.plus(twoFranc).times(2));
    }

    @Test
    public void test_multiple_addition() throws Exception {
        Money oneFranc = Money.franc(1);
        Money twoFranc = Money.franc(2);
        Money threeFranc = Money.franc(3);
        assertEquals(Money.franc(6), oneFranc.plus(twoFranc).plus(threeFranc));
    }

    @Test
    public void test_multiple_times() throws Exception {
        Money oneFranc = Money.franc(1);
        assertEquals(Money.franc(6), oneFranc.times(2).times(3));
    }
}
