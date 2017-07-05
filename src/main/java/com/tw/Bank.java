package com.tw;

class Bank {

    private int rate;

    Bank() {
    }

    Money reduce(Expression source, String toCurrency) {
        return source.reduce(toCurrency, this);
    }

    int rate(String fromCurrency, String toCurrency) {
        if (fromCurrency.equals(toCurrency)) {
            return 1; //这里要return1，不可以rate=1，否则重置rate，会产生错误
        }
        return rate;
    }

    public void setRate(String from, String to, int rate) {
        if(from.equals("USD") && to.equals("CHF")){
            this.rate = rate;
        }
    }
}