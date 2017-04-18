package com.app.mgtg.notes;

import com.app.mgtg.domain.GalacticSymbol;

import java.util.List;

import static com.app.mgtg.domain.RomanSymbol.getSymbolFor;

public class GalacticSymbolNote implements Note {
    private List<GalacticSymbol> galacticSymbols;
    private String line;

    public GalacticSymbolNote(String line, List<GalacticSymbol> galacticSymbols) {
        this.galacticSymbols = galacticSymbols;
        this.line = line;
    }

    @Override
    public void process() {
        String[] tokens = line.split(" ");
        galacticSymbols.add(new GalacticSymbol(tokens[0], getSymbolFor(tokens[2])));
    }
}
