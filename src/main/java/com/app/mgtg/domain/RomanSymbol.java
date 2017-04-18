package com.app.mgtg.domain;

public enum RomanSymbol {
    I(1), V(5), X(10), L(50), C(100), D(500), M(1000);

    private int value;

    RomanSymbol(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static RomanSymbol getSymbolFor(String name) {
        return RomanSymbol.valueOf(name);
    }
}
