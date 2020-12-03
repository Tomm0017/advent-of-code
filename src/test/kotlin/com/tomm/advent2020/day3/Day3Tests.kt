package com.tomm.advent2020.day3

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day3Tests {

    private val input = """
        ..##.......
        #...#...#..
        .#....#..#.
        ..#.#...#.#
        .#...##..#.
        ..#.##.....
        .#.#.#....#
        .#........#
        #.##...#...
        #...##....#
        .#..#...#.#
    """.trimIndent()

    @Test
    fun testPart1() {
        val map = MapParser().parse(input.lineSequence())
        Assertions.assertEquals("7", Day3.steps[0].solve(map))
    }

    @Test
    fun testPart2() {
        val map = MapParser().parse(input.lineSequence())
        Assertions.assertEquals("336", Day3.steps[1].solve(map))
    }
}
