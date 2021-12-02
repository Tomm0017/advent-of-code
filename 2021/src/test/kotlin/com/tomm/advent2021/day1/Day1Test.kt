package com.tomm.advent2021.day1

import com.tomm.IntListParser
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

object Day1Test {

    private val input = """
        199
        200
        208
        210
        200
        207
        240
        269
        260
        263
    """.trimIndent()

    @Test
    fun testPart1() {
        val input = IntListParser().parse(input.lineSequence())
        Assertions.assertEquals("7", Day1.steps[0].solve(input))
    }

    @Test
    fun testPart2() {
        val input = IntListParser().parse(input.lineSequence())
        Assertions.assertEquals("5", Day1.steps[1].solve(input))
    }
}