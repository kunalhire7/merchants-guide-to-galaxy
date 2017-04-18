package com.app.mgtg.validators;

import com.app.mgtg.exceptions.MerchantsGuideToGalaxyException;

import java.util.List;

import static com.app.mgtg.constants.Constants.*;
import static com.app.mgtg.domain.RomanSymbol.getSymbolFor;
import static java.util.Arrays.asList;

public class RepetitionRuleValidator implements Validator {

    private static List<String> validSymbols = asList(VALID_SYMBOLS);
    private static List<String> nonRepeatableSymbols = asList(NON_REPEATABLE_SYMBOLS);
    private static List<String> repeatableSymbols = asList(REPEATABLE_SYMBOLS);

    @Override
    public boolean validate(String romanNumber) throws MerchantsGuideToGalaxyException {
        char[] arr = romanNumber.toCharArray();
        int repeatCount = 1;
        int repeatIndex = -1;
        String currSymbol;
        char c;
        char prevChar = Character.MAX_VALUE;
        String repeatedSymbol = null;
        for (int i = 0; i < arr.length; i++) {
            c = arr[i];
            currSymbol = "" + c;
            checkValidSymbol(currSymbol, c);
            repeatCount = handleRepetition(repeatCount, currSymbol, c, prevChar);
            checkMaxAllowedRepetition(repeatCount, c);
            if (repeatCount == MAX_ALLOWED_REPETITIONS) {
                repeatedSymbol = currSymbol;
                repeatIndex = i;
            }
            if (i == repeatIndex + 2) {
                if (currSymbol.equals(repeatedSymbol)
                        && getSymbolFor("" + arr[i - 1]).getValue() > getSymbolFor(repeatedSymbol).getValue()) {
                    throw new MerchantsGuideToGalaxyException("ILLEGAL REPETITION : " + romanNumber);
                }
            }
            prevChar = c;
        }
        return true;
    }

    private void checkMaxAllowedRepetition(int repeatCount, char c) throws MerchantsGuideToGalaxyException {
        if (repeatCount > MAX_ALLOWED_REPETITIONS) {
            throw new MerchantsGuideToGalaxyException("SYMBOL IS REPEATED FOR MORE THAN MAXIMUM ALLOWED REPETITIONS : " + c);
        }
    }

    private int handleRepetition(int repeatCount, String currSymbol, char c, char prevChar) throws MerchantsGuideToGalaxyException {
        if (c == prevChar) {
            if (nonRepeatableSymbols.contains(currSymbol)) {
                throw new MerchantsGuideToGalaxyException("REPETITION IS NOT ALLOWED : " + c);
            } else if (repeatableSymbols.contains(currSymbol)) {
                repeatCount++;
            }
        } else {
            repeatCount = 1;
        }
        return repeatCount;
    }

    private void checkValidSymbol(String currSymbol, char c) throws MerchantsGuideToGalaxyException {
        if (!validSymbols.contains(currSymbol)) {
            throw new MerchantsGuideToGalaxyException("INVALID SYMBOL : " + c);
        }
    }

}
