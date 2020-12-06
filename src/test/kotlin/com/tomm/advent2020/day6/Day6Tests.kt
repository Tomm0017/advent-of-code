package com.tomm.advent2020.day6

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day6Tests {

    private val input = """
        abc

        a
        b
        c

        ab
        ac

        a
        a
        a
        a

        b
    """.trimIndent()

    @Test
    fun testPart1() {
        val input = QuestionnaireParser().parse(input.lineSequence())
        Assertions.assertEquals("11", Day6.steps[0].solve(input))
    }

    @Test
    fun testPart2() {
        val input = QuestionnaireParser().parse(input.lineSequence())
        Assertions.assertEquals("6", Day6.steps[1].solve(input))
    }
}
