package com.app.mgtg.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class Metals {

    private List<Metal> metals;

    public Metals() {
        this.metals = new ArrayList<>();
    }

    public boolean add(Metal metal) {
        return this.metals.add(metal);
    }

    public Optional<Metal> getMetalFor(String metalName) {
        return metals.stream().filter(metalNameMatcherPredicate(metalName)).findFirst();
    }

    public boolean isMetal(String potentialMetalName) {
        return metals.stream().anyMatch(metalNameMatcherPredicate(potentialMetalName));
    }

    public List<Metal> getMetals() {
        return metals;
    }

    private Predicate<Metal> metalNameMatcherPredicate(String potentialMetalName) {
        return metal -> metal.getName().equals(potentialMetalName);
    }
}
