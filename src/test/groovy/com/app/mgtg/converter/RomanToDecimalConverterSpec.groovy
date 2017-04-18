package com.app.mgtg.converter

import spock.lang.Specification

class RomanToDecimalConverterSpec extends Specification {

    RomanToDecimalConverter converter

    def "should covert the given Roman number into corresponding decimal number"() {
        given:
        converter = new RomanToDecimalConverter()

        when:
        def convertedNumber = converter.convert(romanNumber)

        then:
        convertedNumber == decimalNumber

        where:
        romanNumber | decimalNumber
        "II"        | 2
        "IV"        | 4
        "MCMXLIV"   | 1944
    }

}
