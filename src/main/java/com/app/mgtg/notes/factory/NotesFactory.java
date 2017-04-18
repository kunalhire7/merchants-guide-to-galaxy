package com.app.mgtg.notes.factory;

import com.app.mgtg.domain.GalacticSymbol;
import com.app.mgtg.domain.Metal;
import com.app.mgtg.notes.*;

import java.util.List;

public class NotesFactory {

    private NotesFactory() {}

    public static Note getNote(String line, List<GalacticSymbol> galacticSymbols, List<Metal> metals) {
        String[] tokens = line.split(" ");

        if(tokens.length == 3 && line.contains("is")) {
            return new GalacticSymbolNote(line, galacticSymbols, metals);
        } else if(line.endsWith("Credits")) {
            return new MetalNote(line, galacticSymbols, metals);
        } else if(line.endsWith("?")) {
            return new QuestionNote(line, galacticSymbols, metals);
        } else {
            return new InvalidNote();
        }
    }
}
