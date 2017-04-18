package com.app.mgtg.notes;

import com.app.mgtg.converter.RomanToDecimalConverter;
import com.app.mgtg.domain.GalacticSymbol;
import com.app.mgtg.domain.Metal;
import com.app.mgtg.exceptions.MerchantsGuideToGalaxyException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.lang.Integer.parseInt;

public class MetalNote implements Note {
    private List<GalacticSymbol> galacticSymbols;
    private List<Metal> metals;
    private String line;

    public MetalNote(String line, List<GalacticSymbol> galacticSymbols, List<Metal> metals) {
        this.galacticSymbols = galacticSymbols;
        this.metals = metals;
        this.line = line;
    }

    @Override
    public void process() {
        String[] tokens = line.split(" ");
        final String[] symbol = {""};
        final String[] metalName = {""};
        final int[] valueForGivenUnits = {0};
        Arrays.stream(tokens).forEach(token -> {
            if (!token.equals("is") && !token.equals("Credits")) {
                Optional<GalacticSymbol> galacticSymbol = getGalacticSymbol(token);
                galacticSymbol.ifPresent(gs -> symbol[0] += gs.getValue().toString());
                if (!galacticSymbol.isPresent()) {
                    if (isNumeric(token)) {
                        valueForGivenUnits[0] = parseInt(token);
                    } else {
                        metalName[0] = token;
                    }
                }
            }
        });
        int valueFoeSingleUnit = computeValue(valueForGivenUnits[0], symbol[0]);
        metals.add(new Metal(metalName[0], valueFoeSingleUnit));
    }

    private int computeValue(int valueForGivenUnits, String romanNumber) {
        RomanToDecimalConverter converter = new RomanToDecimalConverter();
        int decimalValue = 1;
        try {
            decimalValue = converter.convert(romanNumber);
        } catch (MerchantsGuideToGalaxyException e) {
            e.printStackTrace();
        }
        return valueForGivenUnits / decimalValue;
    }

    private boolean isNumeric(String token) {
        try {
            parseInt(token);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private Optional<GalacticSymbol> getGalacticSymbol(String token) {
        return galacticSymbols.stream().filter(symbol -> symbol.getName().equals(token)).findFirst();
    }
}
