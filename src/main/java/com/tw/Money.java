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

    public Money times(int multiplier) {
        return new Money(amount * multiplier, this.getCurrency());
    }

    public Money plus(Money addend) {
        return new Money(this.amount + addend.amount, this.getCurrency());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;

        Money money = (Money) o;

        if (amount != money.amount) return false;
        return currency != null ? currency.equals(money.currency) : money.currency == null;
    }

    @Override
    public int hashCode() {
        int result = amount;
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        return result;
    }
}
