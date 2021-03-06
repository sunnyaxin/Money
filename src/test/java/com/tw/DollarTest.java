package com.tw;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class DollarTest {
    private  Bank bank;

    @Before
    public void setUp() throws Exception {
        bank = new Bank();
        bank.setRate(new Pair(Currency.USD, Currency.CHF), 2);
    }

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
        assertEquals(Currency.USD, Money.dollar(1).getCurrency());
    }

    @Test
    public void test_franc_currency_type() throws Exception {
        assertEquals(Currency.CHF, Money.franc(1).getCurrency());
    }

    @Test
    public void test_reduce_same_currency() throws Exception {
        assertEquals(Money.dollar(1), bank.reduce(Money.dollar(1), Currency.USD));
        assertEquals(Money.franc(1), bank.reduce(Money.franc(1), Currency.CHF));
    }

    @Test
    public void test_reduce_one_dollar_is_two_franc() throws Exception {
        assertEquals(Money.franc(2), bank.reduce(Money.dollar(1), Currency.CHF));
    }

    @Test
    public void test_reduce_one_dollar_plus_two_francs_equals_four_francs() throws Exception {
        assertEquals(Money.franc(4), bank.reduce(new Sum(Money.dollar(1), Money.franc(2)), Currency.CHF));
    }

    @Test
    public void test_reduce_one_dollar_plus_two_francs_plus_three_francs() throws Exception {
        assertEquals(Money.franc(7), bank.reduce(new Sum(Money.dollar(1), Money.franc(2)), Currency.CHF).plus(Money.franc(3)));
    }

    @Test
    public void test_sum_plus_sum() throws Exception {
        Sum sum = new Sum(Money.dollar(1), Money.franc(2));
        assertEquals(Money.franc(8), bank.reduce(sum.plus(sum), Currency.CHF));
    }

    @Test
    public void test_sum_times_three() throws Exception {
        Sum sum = new Sum(Money.dollar(1), Money.franc(2));
        assertEquals(Money.franc(12), bank.reduce(sum.times(3), Currency.CHF));
    }

    @Test
    public void final_test() throws Exception {
        Expression source = Money.dollar(1).plus(Money.dollar(2)).times(3).plus(Money.franc(4)).times(5);
        assertEquals(Money.franc(110), bank.reduce(source, Currency.CHF));
    }
}
