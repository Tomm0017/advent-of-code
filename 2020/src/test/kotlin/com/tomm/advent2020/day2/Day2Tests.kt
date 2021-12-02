package com.tomm.advent2020.day2

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day2Tests {

    private val input = sequenceOf(
        "1-3 a: abcde",
        "1-3 b: cdefg",
        "2-9 c: ccccccccc"
    )

    @Test
    fun testPart1() {
        val passwords = PasswordListParser().parse(input)
        Assertions.assertEquals("2", Day2.steps[0].solve(passwords))
    }

    @Test
    fun testPart2() {
        val passwords = PasswordListParser().parse(input)
        Assertions.assertEquals("1", Day2.steps[1].solve(passwords))
    }
}
