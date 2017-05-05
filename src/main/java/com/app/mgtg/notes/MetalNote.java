package com.app.mgtg.notes;

import com.app.mgtg.converter.RomanToDecimalConverter;
import com.app.mgtg.domain.GalacticSymbols;
import com.app.mgtg.domain.Metal;
import com.app.mgtg.domain.Metals;
import com.app.mgtg.exceptions.MerchantsGuideToGalaxyException;

import static com.app.mgtg.constants.Constants.KEYWORDS;
import static com.app.mgtg.util.MgtgUtility.isNumeric;
import static java.lang.Integer.parseInt;

public class MetalNote implements Note {
    private GalacticSymbols galacticSymbols;
    private Metals metals;

    public MetalNote(GalacticSymbols galacticSymbols, Metals metals) {
        this.galacticSymbols = galacticSymbols;
        this.metals = metals;
    }

    @Override
    public void process(String note) {
        String[] tokens = note.split(" ");
        String metalName = null;
        int valueForGivenUnits = 0;
        StringBuilder symbolsInNote = new StringBuilder();
        for(String token : tokens) {
            if (!KEYWORDS.contains(token)) {
                if(galacticSymbols.isGalacticSymbol(token)) {
                    symbolsInNote.append(token).append(" ");
                } else {
                    if (isNumeric(token)) {
                        valueForGivenUnits = parseInt(token);
                    } else {
                        metalName = token;
                    }
                }
            }
        }

        float valueForSingleUnit = computeValue(valueForGivenUnits, galacticSymbols.getRomanNumberForSymbols(symbolsInNote.toString()));
        metals.add(new Metal(metalName, valueForSingleUnit));
    }

    private float computeValue(int valueForGivenUnits, String romanNumber) {
        RomanToDecimalConverter converter = new RomanToDecimalConverter();
        int decimalValue = 1;
        try {
            decimalValue = converter.convert(romanNumber);
        } catch (MerchantsGuideToGalaxyException e) {
            e.printStackTrace();
        }
        return (float) valueForGivenUnits / decimalValue;
    }

    public Metals getMetals() {
        return metals;
    }
}
