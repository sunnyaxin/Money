package com.tw;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BankTest {

    private static final double DELTA = 0.01;
    private Bank bank;

    @Before
    public void setUp() throws Exception {
        bank = new Bank();
        bank.setRate(new Pair(Currency.USD, Currency.CHF), 2);
    }

    @Test
    public void test_rate_dollar_to_dollar() throws Exception {
        assertEquals(1, bank.rate(Currency.USD, Currency.USD), DELTA);
    }

    @Test
    public void test_rate_franc_to_franc() throws Exception {
        assertEquals(1, bank.rate(Currency.CHF, Currency.CHF), DELTA);
    }

    @Test
    public void test_rate_dollar_to_franc() throws Exception {
        assertEquals(2, bank.rate(Currency.USD, Currency.CHF), DELTA);
    }

    @Test
    public void test_set_rate_dollar_to_franc() throws Exception {
        bank.setRate(new Pair(Currency.USD, Currency.CHF), 3);
        assertEquals(3, bank.rate(Currency.USD, Currency.CHF), DELTA);
    }

    @Test
    public void test_set_rate_dollar_to_rmb() throws Exception {
        bank.setRate(new Pair(Currency.USD, Currency.CNY), 7);
        assertEquals(7, bank.rate(Currency.USD, Currency.CNY), DELTA);
    }

    @Test
    public void test_rate_franc_to_dollar() throws Exception {
        bank.setRate(new Pair(Currency.CHF, Currency.USD), 0.5);
        assertEquals(0.5, bank.rate(Currency.CHF, Currency.USD), DELTA);
    }
}
