package com.tw;

import java.util.HashMap;

class Bank {

    private HashMap<Pair, Double> rates = new HashMap<>();

    Bank() {
    }

    Money reduce(Expression source, Currency toCurrency) {
        return source.reduce(toCurrency, this);
    }

    double rate(Currency from, Currency to) {
        if (from.equals(to)) {
            return 1; //这里要return1，不可以rate=1，否则重置rate，会产生错误
        }
        return rates.get(new Pair(from, to));
    }


    void setRate(Pair pair, double rate) {
        rates.put(pair, rate);
    }
}