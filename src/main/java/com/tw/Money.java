package com.tw;

public class Money {
    int amount;
    private String currency;

    private Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    static Money dollar(int amount) {
        return new Money(amount, "USD");
    }

    static Money franc(int amount) {
        return new Money(amount, "CHF");
    }

    String getCurrency() {
        return currency;
    }

    Money times(int multiplier) {
        return new Money(amount * multiplier, this.getCurrency());
    }

    Money plus(Money addend) {
        return new Money(this.amount + addend.amount, this.getCurrency());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Money money = (Money) o;

        return amount == money.amount && (currency != null ? currency.equals(money.currency) : money.currency == null);
    }

    @Override
    public int hashCode() {
        int result = amount;
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        return result;
    }
}
