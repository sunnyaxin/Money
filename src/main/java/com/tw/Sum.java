package com.tw;

class Sum implements Expression{
    private final Money addend;
    private final Money augend;

    Sum(Money addend, Money augend) {
        this.addend = addend;
        this.augend = augend;
    }

    private Money getAddend() {
        return addend;
    }

    private Money getAugend() {
        return augend;
    }

    @Override
    public Money reduce(String toCurrency, Bank bank) {
        return bank.reduce(getAddend(), toCurrency).plus(bank.reduce(getAugend(), toCurrency));
    }
}
