package com.app.mgtg.notes

import com.app.mgtg.domain.GalacticSymbol
import com.app.mgtg.domain.Metal
import spock.lang.Specification

import static com.app.mgtg.domain.RomanSymbol.I

class MetalNoteSpec extends Specification {

    Note note

    def "should process the metal note"() {
        given:
        def galacticSymbols = [new GalacticSymbol("glob", I)]
        note = new MetalNote("glob glob Silver is 34 Credits", galacticSymbols, [])

        when:
        note.process()

        then:
        note.metals == [new Metal("Silver", 17)]
    }

}
