package com.app.mgtg.notes

import com.app.mgtg.domain.GalacticSymbol
import com.app.mgtg.domain.GalacticSymbols
import spock.lang.Specification

import static com.app.mgtg.domain.RomanSymbol.I

class GalacticSymbolNoteSpec extends Specification {
    Note note

    def "should process the galactic symbol note"() {
        given:
        note = new GalacticSymbolNote(new GalacticSymbols())

        when:
        note.process("glob is I")

        then:
        note.galacticSymbols.symbols == [new GalacticSymbol("glob", I)]
    }
}
