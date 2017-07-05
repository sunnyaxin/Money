package com.tw;

class Bank {

    private int rate;

    Bank() {
    }

    Money reduce(Expression source, String toCurrency) {
        return source.reduce(toCurrency, this);
    }

    int rate(String fromCurrency, String toCurrency) {
        rate = 1;
        if (fromCurrency.equals("USD") && toCurrency.equals("CHF")) {
            rate = 2;
        }
        return rate;
    }

    public void setRate(String from, String to, int rate) {
        if(from.equals("USD") && to.equals("CHF")){
            this.rate = rate;
        }
    }
}