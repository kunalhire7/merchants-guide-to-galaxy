package com.app.mgtg.converter;

import com.app.mgtg.exceptions.MerchantsGuideToGalaxyException;
import com.app.mgtg.validators.RepetitionRuleValidator;
import com.app.mgtg.validators.SubtractionRuleValidator;
import com.app.mgtg.validators.Validator;

import static com.app.mgtg.domain.RomanSymbol.getSymbolFor;

public class RomanToDecimalConverter {

	public int convert(String romanNumber) throws MerchantsGuideToGalaxyException {
		romanNumber = romanNumber.toUpperCase();
		int decimal = 0;
		int lastNumber = 0;
		Validator repetitionValidator = new RepetitionRuleValidator();
		Validator subtractionValidator = new SubtractionRuleValidator();
		if (repetitionValidator.validate(romanNumber)
				&& subtractionValidator.validate(romanNumber)) {
			for (int i = romanNumber.length() - 1; i >= 0; i--) {
				String currentSymbol = romanNumber.charAt(i) + "";
				decimal = executeOperation(getSymbolFor(currentSymbol).getValue(), lastNumber, decimal);
				lastNumber = getSymbolFor(currentSymbol).getValue();
			}
		}
		return decimal;
	}

	private int executeOperation(int decimal, int lastNumber, int lastDecimal) {
		if (lastNumber > decimal) {
			return lastDecimal - decimal;
		} else {
			return lastDecimal + decimal;
		}
	}

}
