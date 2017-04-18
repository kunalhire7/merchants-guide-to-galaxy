package com.app.mgtg.validators;

import com.app.mgtg.exceptions.MerchantsGuideToGalaxyException;

import static com.app.mgtg.domain.RomanSymbol.getSymbolFor;

public class SubtractionRuleValidator implements Validator {

    @Override
    public boolean validate(String romanNumber) throws MerchantsGuideToGalaxyException {
        char[] arr = romanNumber.toCharArray();
        String currSymbol;
        String nextSymbol;
        String nextNextSymbol;
        if (arr.length >= 3) {
            for (int i = arr.length - 3; i >= 0; i--) {
                currSymbol = "" + arr[i + 2];
                nextSymbol = "" + arr[i + 1];
                nextNextSymbol = "" + arr[i];
                if (getSymbolFor(nextSymbol).getValue() < getSymbolFor(currSymbol).getValue()) {
                    if (getSymbolFor(nextNextSymbol).getValue() < getSymbolFor(nextSymbol).getValue()) {
                        throw new MerchantsGuideToGalaxyException("INVALID SYMBOL - FOUND ILLEGAL SUBTRACTION.");
                    }
                }
            }
        }
        return true;
    }

}
