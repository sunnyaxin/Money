package com.tw;

public class Dollar extends Money{

    public Dollar(int amount) {
        super(amount, "USD");
    }

    public Dollar times(int multiplier) {
        return new Dollar(amount * multiplier);
    }

    public Dollar plus(Dollar addend) {
        return new Dollar(this.amount + addend.amount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dollar dollar = (Dollar) o;

        return amount == dollar.amount;
    }

}
