package com.app.mgtg.validators

import com.app.mgtg.exceptions.MerchantsGuideToGalaxyException
import spock.lang.Specification

class RepetitionRuleValidatorSpec extends Specification {

    Validator validator

    def "should throw an exception for invalid symbol"() {
        given:
        validator = new RepetitionRuleValidator()

        when:
        validator.validate(symbol)

        then:
        MerchantsGuideToGalaxyException e = thrown()
        e.message == expectedMessage

        where:
        symbol  | expectedMessage
        "A"     | "INVALID SYMBOL : A"
        "XXXX"  | "SYMBOL IS REPEATED FOR MORE THAN MAXIMUM ALLOWED REPETITIONS : X"
        "DDD"   | "REPETITION IS NOT ALLOWED : D"
        "XXXLX" | "ILLEGAL REPETITION : XXXLX"
    }

    def "should not throw any exception when repetition is valid"() {
        given:
        validator = new RepetitionRuleValidator()
        def symbol = "XXIX"

        when:
        validator.validate(symbol)

        then:
        noExceptionThrown()
    }

}
