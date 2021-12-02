package com.tomm.advent2021.day2

import com.tomm.advent2021.day2.movement.MovementParser
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

object Day2Test {

    private val input = """
        forward 5
        down 5
        forward 8
        up 3
        down 8
        forward 2
    """.trimIndent()

    @Test
    fun testPart1() {
        val input = MovementParser().parse(input.lineSequence())
        Assertions.assertEquals("150", Day2.steps[0].solve(input))
    }

    @Test
    fun testPart2() {
        val input = MovementParser().parse(input.lineSequence())
        Assertions.assertEquals("900", Day2.steps[1].solve(input))
    }
}