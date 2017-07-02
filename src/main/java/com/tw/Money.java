package com.tw;

public class Money {
    protected int amount;

    public Money(int amount) {
        this.amount = amount;
    }

    @Override
    public int hashCode() {
        return amount;
    }
}
