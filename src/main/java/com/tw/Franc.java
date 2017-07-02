package com.tw;

public class Franc {
    int amount;

    public Franc(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Franc franc = (Franc) o;

        return amount == franc.amount;
    }

    @Override
    public int hashCode() {
        return amount;
    }

    public Franc times(int multipler) {
        return new Franc(this.amount * multipler);
    }

    public Franc plus(Franc franc) {
        return new Franc(this.amount + franc.amount);
    }
}
