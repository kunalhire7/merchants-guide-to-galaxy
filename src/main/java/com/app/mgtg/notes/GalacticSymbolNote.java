package com.app.mgtg.notes;

import com.app.mgtg.domain.GalacticSymbol;
import com.app.mgtg.domain.Metal;

import java.util.List;

public class GalacticSymbolNote implements Note {
    private List<GalacticSymbol> galacticSymbols;
    private List<Metal> metals;
    private String line;

    public GalacticSymbolNote(String line, List<GalacticSymbol> galacticSymbols, List<Metal> metals) {
        this.galacticSymbols = galacticSymbols;
        this.metals = metals;
        this.line = line;
    }
}
