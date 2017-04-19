package com.app.mgtg.domain

import spock.lang.Specification

class MetalsSpec extends Specification {

    Metals metals = new Metals()

    def "add() should add metals"() {
        given:
        def name = "Silver"
        def metal = new Metal(name, 17)

        when:
        metals.add(metal)

        then:
        metals.isMetal(name)
        metals.getMetalFor(name).isPresent()
        metals.metals[0] == metal
    }
}
