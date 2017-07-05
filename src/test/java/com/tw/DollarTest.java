package com.tw;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class DollarTest {
    private final Bank bank = new Bank();

    @Test
    public void test_one_dollar_equals_one_dollar() throws Exception {
        assertEquals(Money.dollar(1), Money.dollar(1));
    }

    @Test
    public void test_one_dollar_not_equals_two_dollar() throws Exception {
        assertNotEquals(Money.dollar(1), Money.dollar(2));
    }

    @Test
    public void test_one_dollar_times_two() throws Exception {
        assertEquals(Money.dollar(2), Money.dollar(1).times(2));
    }

    @Test
    public void test_one_dollar_plus_one_dollar() throws Exception {
        Money oneMoney = Money.dollar(1);
        Money anotherOneMoney = Money.dollar(1);
        assertEquals(Money.dollar(2), oneMoney.plus(anotherOneMoney));
    }

    @Test
    public void test_multiple_addition_times() throws Exception {
        Money oneMoney = Money.dollar(1);
        Money twoMoney = Money.dollar(2);
        assertEquals(Money.dollar(6), oneMoney.plus(twoMoney).times(2));
    }

    @Test
    public void test_multiple_addition() throws Exception {
        Money oneMoney = Money.dollar(1);
        Money twoMoney = Money.dollar(2);
        Money threeMoney = Money.dollar(3);
        assertEquals(Money.dollar(6), oneMoney.plus(twoMoney).plus(threeMoney));
    }

    @Test
    public void test_multiple_times() throws Exception {
        Money oneMoney = Money.dollar(1);
        assertEquals(Money.dollar(6), oneMoney.times(2).times(3));
    }

    @Test
    public void test_dollar_currency_type() throws Exception {
        assertEquals("USD", Money.dollar(1).getCurrency());
    }

    @Test
    public void test_franc_currency_type() throws Exception {
        assertEquals("CHF", Money.franc(1).getCurrency());
    }

    @Test
    public void test_reduce_same_currency() throws Exception {
        assertEquals(Money.dollar(1), bank.reduce(Money.dollar(1), "USD"));
        assertEquals(Money.franc(1), bank.reduce(Money.franc(1), "CHF"));
    }

    @Test
    public void test_reduce_one_dollar_is_two_franc() throws Exception {
        assertEquals(Money.franc(2), bank.reduce(Money.dollar(1), "CHF"));
    }
}
