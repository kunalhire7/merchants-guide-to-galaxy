package com.app.mgtg.domain

import spock.lang.Specification

import static com.app.mgtg.domain.RomanSymbol.I
import static com.app.mgtg.domain.RomanSymbol.V

class GalacticSymbolsSpec extends Specification {

    GalacticSymbols galacticSymbols = new GalacticSymbols()

    def "add() should add galactic symbol"() {
        given:
        def symbol = new GalacticSymbol("glob", I)

        when:
        galacticSymbols.add(symbol)

        then:
        galacticSymbols.isGalacticSymbol("glob")
        galacticSymbols.getSymbols().get(0) == symbol
    }

    def "getRomanNumberForSymbols() should return the roman number for the symbol"() {
        given:
        galacticSymbols.add(new GalacticSymbol("glob", I))
        galacticSymbols.add(new GalacticSymbol("prok", V))
        def symbolsInNote = "prok glob glob"

        when:
        def romanNumber = galacticSymbols.getRomanNumberForSymbols(symbolsInNote)

        then:
        romanNumber == "VII"
    }

}
