package com.app.mgtg.notes

import com.app.mgtg.domain.GalacticSymbol
import spock.lang.Specification

import static com.app.mgtg.domain.RomanSymbol.I

class GalacticSymbolNoteSpec extends Specification {
    Note note

    def "should process the galactic symbol note"() {
        given:
        note = new GalacticSymbolNote("glob is I", [])

        when:
        note.process()

        then:
        note.galacticSymbols == [new GalacticSymbol("glob", I)]
    }
}
