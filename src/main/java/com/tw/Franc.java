package com.tw;

public class Franc extends Money {

    public Franc(int amount) {
        super(amount, "CHF");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Franc franc = (Franc) o;

        return amount == franc.amount;
    }

    public Franc times(int multiplier) {
        return new Franc(this.amount * multiplier);
    }

    public Franc plus(Franc franc) {
        return new Franc(this.amount + franc.amount);
    }
}
