package com.app.mgtg.validators;

import com.app.mgtg.exceptions.MerchantsGuideToGalaxyException;

public interface Validator {
    boolean validate(String romanNumber) throws MerchantsGuideToGalaxyException;
}
