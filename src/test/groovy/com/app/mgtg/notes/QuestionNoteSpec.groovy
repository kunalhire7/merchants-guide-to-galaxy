package com.app.mgtg.notes

import com.app.mgtg.domain.GalacticSymbol
import com.app.mgtg.domain.Metal
import spock.lang.Specification

import static com.app.mgtg.constants.Constants.UNKNOWN_ANSWER
import static com.app.mgtg.domain.RomanSymbol.I
import static com.app.mgtg.domain.RomanSymbol.L
import static com.app.mgtg.domain.RomanSymbol.V
import static com.app.mgtg.domain.RomanSymbol.X

class QuestionNoteSpec extends Specification {

    Note note
    PrintStream out

    def setup() {
        out = Mock(PrintStream)
        System.setOut(out)
    }

    def "should process the question note staring with 'how many'"() {
        given:
        def line = "how many Credits is glob prok Silver ?"
        def galacticSymbols = [new GalacticSymbol("glob", I), new GalacticSymbol("prok", V)]
        def metals = [new Metal("Silver", 17)]
        note = new QuestionNote(line, galacticSymbols, metals)

        when:
        note.process()

        then:
        1 * System.out.println("glob prok Silver is 68 Credits")
    }

    def "should print UNKNOWN ANSWER for unknown question"() {
        given:
        def line = "how much wood could a woodchuck chuck if a woodchuck could chuck wood ?"
        def galacticSymbols = [new GalacticSymbol("glob", I), new GalacticSymbol("prok", V)]
        def metals = [new Metal("Silver", 17)]
        note = new QuestionNote(line, galacticSymbols, metals)

        when:
        note.process()

        then:
        1 * System.out.println(UNKNOWN_ANSWER)
    }

    def "should process the question note staring with 'how much is'"() {
        given:
        def line = "how much is pish tegj glob glob ?"
        def galacticSymbols = [new GalacticSymbol("glob", I), new GalacticSymbol("pish", X), new GalacticSymbol("tegj", L)]
        def metals = []
        note = new QuestionNote(line, galacticSymbols, metals)

        when:
        note.process()

        then:
        1 * System.out.println("pish tegj glob glob is 42")
    }
}
