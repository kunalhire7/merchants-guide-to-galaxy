package com.app.mgtg.domain;

public class Metal {
    private String name;
    private float value;

    public Metal(String name, float value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public float getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Metal)) return false;

        Metal metal = (Metal) o;

        return Float.compare(metal.getValue(), getValue()) == 0 && getName().equals(metal.getName());
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + (getValue() != +0.0f ? Float.floatToIntBits(getValue()) : 0);
        return result;
    }
}
