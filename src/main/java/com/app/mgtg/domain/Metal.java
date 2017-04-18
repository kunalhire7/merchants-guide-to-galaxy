package com.app.mgtg.domain;

public class Metal {
    private String name;
    private int value;

    public Metal(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Metal)) return false;

        Metal metal = (Metal) o;

        return getValue() == metal.getValue() && getName().equals(metal.getName());
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getValue();
        return result;
    }
}
