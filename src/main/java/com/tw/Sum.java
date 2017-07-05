package com.tw;

class Sum implements Expression {
    private final Expression addend;
    private final Expression augend;

    Sum(Expression addend, Expression augend) {
        this.addend = addend;
        this.augend = augend;
    }

    private Expression getAddend() {
        return addend;
    }

    private Expression getAugend() {
        return augend;
    }

    @Override
    public Money reduce(String toCurrency, Bank bank) {
        Money reduceAddend = bank.reduce(getAddend(), toCurrency);
        Money reduceAugend = bank.reduce(getAugend(), toCurrency);
        return (Money) reduceAddend.plus(reduceAugend);
    }

    @Override
    public Expression plus(Expression expression) {
        return new Sum(this, expression);
    }

    @Override
    public Expression times(int multiplier) {
        return new Sum(this.addend.times(multiplier), this.augend.times(multiplier) );
    }
}
