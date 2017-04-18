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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GalacticSymbol)) return false;

        GalacticSymbol that = (GalacticSymbol) o;

        return getName().equals(that.getName()) && getValue() == that.getValue();
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getValue().hashCode();
        return result;
    }
}
