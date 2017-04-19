package com.app.mgtg.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class GalacticSymbols {
    private List<GalacticSymbol> symbols;

    public GalacticSymbols() {
        this.symbols = new ArrayList<>();
    }

    public boolean add(GalacticSymbol galacticSymbol) {
        return this.symbols.add(galacticSymbol);
    }

    public List<GalacticSymbol> getSymbols() {
        return symbols;
    }

    public String getRomanNumberForSymbols(String symbols) {
        StringBuilder sb = new StringBuilder();
        String[] tokens = symbols.split(" ");
        for(String token : tokens) {
            Optional<GalacticSymbol> galacticSymbol = getGalacticSymbolFor(token);
            if(galacticSymbol.isPresent()) {
                sb.append(galacticSymbol.get().getValue().toString());
            } else {
                System.out.println("Invalid Galactic symbol: " + token + "\nExiting..");
                System.exit(0);
            }
        }
        return sb.toString();
    }

    public boolean isGalacticSymbol(String potentialSymbol) {
        return symbols.stream().anyMatch(galacticSymbolNameMatcherPredicate(potentialSymbol));
    }

    private Predicate<GalacticSymbol> galacticSymbolNameMatcherPredicate(String potentialSymbol) {
        return galacticSymbol -> galacticSymbol.getName().equals(potentialSymbol);
    }

    private Optional<GalacticSymbol> getGalacticSymbolFor(final String symbolName) {
        return symbols.stream().filter(galacticSymbolNameMatcherPredicate(symbolName)).findFirst();
    }
}
