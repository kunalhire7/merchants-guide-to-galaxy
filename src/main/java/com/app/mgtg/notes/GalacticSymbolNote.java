package com.app.mgtg.notes;

import com.app.mgtg.domain.GalacticSymbol;
import com.app.mgtg.domain.GalacticSymbols;

import static com.app.mgtg.domain.RomanSymbol.getSymbolFor;

public class GalacticSymbolNote implements Note {
    private GalacticSymbols galacticSymbols;

    public GalacticSymbolNote(GalacticSymbols galacticSymbols) {
        this.galacticSymbols = galacticSymbols;
    }

    @Override
    public void process(String note) {
        String[] tokens = note.split(" ");
        galacticSymbols.add(new GalacticSymbol(tokens[0], getSymbolFor(tokens[2])));
    }

    public GalacticSymbols getGalacticSymbols() {
        return galacticSymbols;
    }
}
