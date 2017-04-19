package com.app.mgtg.notes.factory

import com.app.mgtg.domain.GalacticSymbols
import com.app.mgtg.domain.Metals
import com.app.mgtg.notes.GalacticSymbolNote
import com.app.mgtg.notes.InvalidNote
import com.app.mgtg.notes.MetalNote
import com.app.mgtg.notes.QuestionNote
import spock.lang.Specification

class NotesFactorySpec extends Specification {

    def "should return correct instance of Note for given line"() {
        when:
        def note = NotesFactory.getNote(line, new GalacticSymbols(), new Metals())

        then:
        note.class == expectedInstance

        where:
        line                                | expectedInstance
        "glob is I"                         | GalacticSymbolNote
        "glob glob Silver is 34 Credits"    | MetalNote
        "how much is pish tegj glob glob ?" | QuestionNote
        "this is invalid note"              | InvalidNote
    }
}
