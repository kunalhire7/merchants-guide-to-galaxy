package com.app.mgtg.domain

import spock.lang.Specification

import static com.app.mgtg.domain.RomanSymbol.*

class RomanSymbolSpec extends Specification {

    def "getValue() should return correct value for the given Roman symbol"() {
        given:
        def symbol = romanSymbol

        when:
        def value = symbol.getValue()

        then:
        value == expectedValue

        where:
        romanSymbol | expectedValue
        I           | 1
        V           | 5
        X           | 10
        L           | 50
        C           | 100
        D           | 500
        M           | 1000
    }

    def "getSymbolFor() should return the correct roman symbol for given string name"() {
        given:
        def name = "X"

        when:
        def symbol = getSymbolFor(name)

        then:
        symbol == X
    }

    def "getSymbolFor() should throw IllegalArgumentException when inpur name is not matched for any symbol"() {
        given:
        def name = "A"

        when:
        getSymbolFor(name)

        then:
        IllegalArgumentException e = thrown()
        e.message == "No enum constant com.app.mgtg.domain.RomanSymbol.A"
    }

}
