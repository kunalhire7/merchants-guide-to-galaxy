package com.app.mgtg.validators

import com.app.mgtg.exceptions.MerchantsGuideToGalaxyException
import spock.lang.Specification

class SubtractionRuleValidatorSpec extends Specification {

    Validator validator

    def "should throw exception when subtraction is illegal"() {
        given:
        validator = new SubtractionRuleValidator()
        def symbol = "IXL"

        when:
        validator.validate(symbol)

        then:
        MerchantsGuideToGalaxyException e = thrown()
        e.message == "INVALID SYMBOL - FOUND ILLEGAL SUBTRACTION."
    }

    def "should not throw any exception when subtraction is legal"() {
        given:
        validator = new SubtractionRuleValidator()
        def symbol = "IX"

        when:
        validator.validate(symbol)

        then:
        noExceptionThrown()
    }
}
