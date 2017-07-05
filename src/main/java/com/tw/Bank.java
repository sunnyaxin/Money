package com.tw;

class Bank {
    Bank() {
    }

    Money reduce(Expression source, String toCurrency) {
        return source.reduce(toCurrency, this);
    }

    int rate(String fromCurrency, String toCurrency) {
        int rate = 1;
        if (fromCurrency.equals("USD") && toCurrency.equals("CHF")) {
            rate = 2;
        }
        return rate;
    }
}