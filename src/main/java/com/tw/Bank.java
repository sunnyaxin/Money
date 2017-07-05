package com.tw;

import java.util.HashMap;

class Bank {

    private HashMap<Pair, Integer> rates = new HashMap<>();

    Bank() {
    }

    Money reduce(Expression source, String toCurrency) {
        return source.reduce(toCurrency, this);
    }

    int rate(String fromCurrency, String toCurrency) {
        if (fromCurrency.equals(toCurrency)) {
            return 1; //这里要return1，不可以rate=1，否则重置rate，会产生错误
        }
        return rates.get(new Pair(fromCurrency, toCurrency));
    }

    void setRate(Pair pair, int rate) {
        rates.put(pair, rate);
    }
}