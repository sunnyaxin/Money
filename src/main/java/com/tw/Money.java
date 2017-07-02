package com.tw;

public class Money {
    int amount;
    private String currency;

    Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public int hashCode() {
        return amount;
    }
}
