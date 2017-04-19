package com.app.mgtg.notes;

import com.app.mgtg.domain.GalacticSymbol;
import com.app.mgtg.domain.GalacticSymbols;

import static com.app.mgtg.domain.RomanSymbol.getSymbolFor;

public class GalacticSymbolNote implements Note {
    private GalacticSymbols galacticSymbols;
    private String line;

    public GalacticSymbolNote(String line, GalacticSymbols galacticSymbols) {
        this.galacticSymbols = galacticSymbols;
        this.line = line;
    }

    @Override
    public void process() {
        String[] tokens = line.split(" ");
        galacticSymbols.add(new GalacticSymbol(tokens[0], getSymbolFor(tokens[2])));
    }

    public GalacticSymbols getGalacticSymbols() {
        return galacticSymbols;
    }
}
