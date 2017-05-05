package com.app.mgtg.notes;

import com.app.mgtg.converter.RomanToDecimalConverter;
import com.app.mgtg.domain.GalacticSymbols;
import com.app.mgtg.domain.Metal;
import com.app.mgtg.domain.Metals;
import com.app.mgtg.exceptions.MerchantsGuideToGalaxyException;

import java.util.Optional;

import static com.app.mgtg.constants.Constants.KEYWORDS;
import static com.app.mgtg.constants.Constants.UNKNOWN_ANSWER;

public class QuestionNote implements Note {
    private GalacticSymbols galacticSymbols;
    private Metals metals;

    public QuestionNote(GalacticSymbols galacticSymbols, Metals metals) {
        this.galacticSymbols = galacticSymbols;
        this.metals = metals;
    }

    @Override
    public void process(String note) {
        final RomanToDecimalConverter converter = new RomanToDecimalConverter();
        String[] tokens = note.split(" ");
        final StringBuilder sb = new StringBuilder();
        if (note.startsWith("how many")) {
            processHowManyNote(converter, tokens, sb);
        } else if (note.startsWith("how much is")) {
            processHowMuchNote(converter, tokens, sb);
        } else {
            System.out.println(UNKNOWN_ANSWER);
        }
    }

    private void processHowManyNote(RomanToDecimalConverter converter, String[] tokens, StringBuilder sb) {
        StringBuilder symbolsInNote = new StringBuilder();
        Optional<Metal> metal = Optional.empty();
        for(String token : tokens) {
            if (!KEYWORDS.contains(token)) {
                if(metals.isMetal(token)) {
                    metal = metals.getMetalFor(token);
                } else {
                    symbolsInNote.append(token).append(" ");
                }
            }
        }

        try {
            if (metal.isPresent()) {
                Float creditsForNoOfUnits = converter.convert(galacticSymbols.getRomanNumberForSymbols(symbolsInNote.toString())) * metal.get().getValue();
                sb.append(symbolsInNote).append(metal.get().getName()).append(" is ").append(creditsForNoOfUnits.intValue()).append(" Credits");
                System.out.println(sb.toString());
            } else {
                System.out.println("No metal found in question note.\n Exiting..");
                System.exit(0);
            }
        } catch (MerchantsGuideToGalaxyException e) {
            handleException(e);
        }

    }

    private void processHowMuchNote(RomanToDecimalConverter converter, String[] tokens, StringBuilder sb) {
        StringBuilder symbolsInNote = new StringBuilder();
        for(String token : tokens) {
            if (!KEYWORDS.contains(token)) {
                symbolsInNote.append(token).append(" ");
            }
        }
        try {
            int convertedValue = converter.convert(galacticSymbols.getRomanNumberForSymbols(symbolsInNote.toString()));
            sb.append(symbolsInNote).append("is ").append(convertedValue);
            System.out.println(sb.toString());
        } catch (MerchantsGuideToGalaxyException e) {
            handleException(e);
        }
    }

    private void handleException(MerchantsGuideToGalaxyException e) {
        System.out.println(e.getMessage());
        System.out.println("Exception occurred, exiting..");
        System.exit(0);
    }

}
