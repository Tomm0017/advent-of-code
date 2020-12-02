package com.tomm.advent2020.day1

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day1Tests {

    @Test
    fun testPart1() {
        val input = listOf(1721, 979, 366, 299, 675, 1456)
        Assertions.assertEquals("514579", Day1.steps[0].solve(input))
    }

    @Test
    fun testPart2() {
        val input = listOf(1721, 979, 366, 299, 675, 1456)
        Assertions.assertEquals("241861950", Day1.steps[1].solve(input))
    }
}
