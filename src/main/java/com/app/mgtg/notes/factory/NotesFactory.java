package com.app.mgtg.notes.factory;

import com.app.mgtg.domain.GalacticSymbols;
import com.app.mgtg.domain.Metals;
import com.app.mgtg.notes.*;

public class NotesFactory {

    private NotesFactory() {}

    public static Note getNote(String line, GalacticSymbols galacticSymbols, Metals metals) {
        String[] tokens = line.split(" ");

        if(tokens.length == 3 && line.contains("is")) {
            return new GalacticSymbolNote(galacticSymbols);
        } else if(line.endsWith("Credits")) {
            return new MetalNote(galacticSymbols, metals);
        } else if(line.endsWith("?")) {
            return new QuestionNote(galacticSymbols, metals);
        } else {
            return new InvalidNote();
        }
    }
}
