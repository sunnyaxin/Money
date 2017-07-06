package com.tw;

public class Money implements Expression {
    private int amount;

    private Currency currency;

    private Money(int amount, Currency currency) {
        this.amount = amount;
        setCurrency(currency);
    }

    static Money dollar(int amount) {
        return new Money(amount, Currency.USD);
    }

    static Money franc(int amount) {
        return new Money(amount, Currency.CHF);
    }

    private void setCurrency(Currency currency) {
        this.currency = currency;
    }

    Currency getCurrency() {
        return currency;
    }

    @Override
    public Money reduce(Currency to, Bank bank) {
        double rate = bank.rate(getCurrency(), to);
        return new Money((int) (amount * rate), to);
    }

    @Override
    public Money times(int multiplier) {
        return new Money(amount * multiplier, getCurrency());
    }

    @Override
    public Expression plus(Expression expression) {
        if (expression instanceof Money) {
            Money addend = (Money) expression;
            if (getCurrency().equals(addend.getCurrency())) {
                return new Money(this.amount + addend.amount, getCurrency());
            }
        }
        return new Sum(this, expression);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Money money = (Money) o;

        return amount == money.amount && currency == money.currency;
    }

    @Override
    public int hashCode() {
        int result = amount;
        result = 31 * result + currency.hashCode();
        return result;
    }
}
