package com.app.mgtg.domain;

public class GalacticSymbol {
    private String name;
    private RomanSymbol value;

    public GalacticSymbol(String name, RomanSymbol value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public RomanSymbol getValue() {
        return value;
    }
}
