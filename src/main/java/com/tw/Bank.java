package com.tw;

class Bank {
    Bank() {
    }

    Money reduce(Money money, String toCurrency) {
        String fromCurrency = money.getCurrency();
        int rate = rate(fromCurrency, toCurrency);
        if (toCurrency.equals("CHF"))
            return Money.franc(money.amount * rate);
        return Money.dollar(money.amount * rate);
    }

    private int rate(String fromCurrency, String toCurrency) {
        int rate = 1;
        if (fromCurrency.equals("USD") && toCurrency.equals("CHF")) {
            rate = 2;
        }
        return rate;
    }
}