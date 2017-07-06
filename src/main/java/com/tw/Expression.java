package com.tw;

public interface Expression {
    Money reduce(Currency toCurrency, Bank bank);

    Expression plus(Expression expression);

    Expression times(int multiplier);
}
