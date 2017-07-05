package com.tw;

public interface Expression {
    Money reduce(String toCurrency, Bank bank);

    Expression plus(Expression expression);

    Expression times(int multiplier);
}
