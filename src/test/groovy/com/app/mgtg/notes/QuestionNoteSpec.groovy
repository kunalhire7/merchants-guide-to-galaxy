package com.app.mgtg.notes

import com.app.mgtg.domain.GalacticSymbol
import com.app.mgtg.domain.GalacticSymbols
import com.app.mgtg.domain.Metal
import com.app.mgtg.domain.Metals
import spock.lang.Specification

import static com.app.mgtg.constants.Constants.UNKNOWN_ANSWER
import static com.app.mgtg.domain.RomanSymbol.*

class QuestionNoteSpec extends Specification {

    Note note
    PrintStream out
    GalacticSymbols galacticSymbols
    Metals metals

    def setup() {
        galacticSymbols = new GalacticSymbols()
        galacticSymbols.add(new GalacticSymbol("glob", I))
        galacticSymbols.add(new GalacticSymbol("prok", V))
        galacticSymbols.add(new GalacticSymbol("tegj", L))
        galacticSymbols.add(new GalacticSymbol("pish", X))

        metals = new Metals()
        metals.add(new Metal("Silver", 17))

        out = Mock(PrintStream)
        System.setOut(out)
    }

    def "should process the question note staring with 'how many'"() {
        given:
        def line = "how many Credits is glob prok Silver ?"
        note = new QuestionNote(galacticSymbols, metals)

        when:
        note.process(line)

        then:
        1 * System.out.println("glob prok Silver is 68 Credits")
    }

    def "should print UNKNOWN ANSWER for unknown question"() {
        given:
        def line = "how much wood could a woodchuck chuck if a woodchuck could chuck wood ?"
        note = new QuestionNote(galacticSymbols, metals)

        when:
        note.process(line)

        then:
        1 * System.out.println(UNKNOWN_ANSWER)
    }

    def "should process the question note staring with 'how much is'"() {
        given:
        def line = "how much is pish tegj glob glob ?"
        note = new QuestionNote(galacticSymbols, metals)

        when:
        note.process(line)

        then:
        1 * System.out.println("pish tegj glob glob is 42")
    }
}
