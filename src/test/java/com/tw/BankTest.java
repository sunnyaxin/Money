package com.tw;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BankTest {

    private Bank bank;

    @Before
    public void setUp() throws Exception {
        bank = new Bank();
        bank.setRate(new Pair("USD", "CHF"), 2);
    }

    @Test
    public void test_rate_dollar_to_dollar() throws Exception {
        assertEquals(1, bank.rate("USD", "USD"));
    }

    @Test
    public void test_rate_franc_to_franc() throws Exception {
        assertEquals(1, bank.rate("CHF", "CHF"));
    }

    @Test
    public void test_rate_dollar_to_franc() throws Exception {
        assertEquals(2, bank.rate("USD", "CHF"));
    }

    @Test
    public void test_set_rate_dollar_to_franc() throws Exception {
        bank.setRate(new Pair("USD", "CHF"), 3);
        assertEquals(3, bank.rate("USD", "CHF"));
    }

    @Test
    public void test_set_rate_dollar_to_rmb() throws Exception {
        bank.setRate(new Pair("USD", "CNY"), 7);
        assertEquals(7, bank.rate("USD", "CNY"));
    }
}
