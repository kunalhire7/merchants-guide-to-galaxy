package com.app.mgtg.notes;

import com.app.mgtg.domain.GalacticSymbol;
import com.app.mgtg.domain.Metal;

import java.util.List;

public class QuestionNote implements Note {
    private List<GalacticSymbol> galacticSymbols;
    private List<Metal> metals;
    private String line;

    public QuestionNote(String line, List<GalacticSymbol> galacticSymbols, List<Metal> metals) {
        this.galacticSymbols = galacticSymbols;
        this.metals = metals;
        this.line = line;
    }
}
