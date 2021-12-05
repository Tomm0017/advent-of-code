package com.tomm.advent2021.day3

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

object Day3Test {

    private val input = """
        00100
        11110
        10110
        10111
        10101
        01111
        00111
        11100
        10000
        11001
        00010
        01010
    """.trimIndent()

    @Test
    fun testPart1() {
        val input = DiagnosticReportParser().parse(input.lineSequence())
        Assertions.assertEquals("198", Day3.steps[0].solve(input))
    }

    @Test
    fun testPart2() {
        val input = DiagnosticReportParser().parse(input.lineSequence())
        Assertions.assertEquals("230", Day3.steps[1].solve(input))
    }
}
