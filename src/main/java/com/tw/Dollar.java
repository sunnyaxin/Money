package com.tw;

/**
 * Created by yxwang on 29/06/2017.
 */
public class Dollar {
    private int amount;

    public Dollar(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object obj) {
        return this.amount == ((Dollar)obj).amount;
    }
}
