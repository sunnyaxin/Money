package com.tw;

public class Money implements Expression {
    private int amount;
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

    @Override
    public Money reduce(String toCurrency, Bank bank) {
        int rate = bank.rate(getCurrency(), toCurrency);
        return new Money(amount * rate, toCurrency);
    }

    @Override
    public Money times(int multiplier) {
        return new Money(amount * multiplier, this.getCurrency());
    }

    @Override
    public Expression plus(Expression expression) {
        if(expression instanceof Money){
            Money addend = (Money)expression;
            if(this.getCurrency().equals(addend.getCurrency())){
                return new Money(this.amount + addend.amount, this.getCurrency());
            }
        }
        return new Sum(this, expression);
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
        return amount;
    }
}
