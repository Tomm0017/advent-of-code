package com.tomm.advent2021

import com.tomm.InputParser
import com.tomm.IntListParser
import com.tomm.Puzzle
import com.tomm.advent2021.day1.Day1
import com.tomm.advent2021.day2.Day2
import com.tomm.advent2021.day2.movement.MovementParser

fun main() {
    val days = arrayOf(
        AdventDay(1, Day1, IntListParser(), "day1.txt"),
        AdventDay(2, Day2, MovementParser(), "day2.txt")
    )
    days.forEach { solve(it) }
}

private fun <T> solve(
    day: Int,
    puzzle: Puzzle<T>,
    parser: InputParser<T>,
    resource: String
) {
    val input = parser.parse(resource)
    println("Day $day")
    puzzle.steps.forEachIndexed { index, step ->
        val solution = step.solve(input)
        println("  Part ${index + 1}: $solution")
    }
}

private fun <T> solve(adventDay: AdventDay<T>) {
    val (day, puzzle, parser, resource) = adventDay
    solve(day, puzzle, parser, resource)
}

private fun <T> InputParser<T>.parse(resource: String): T {
    val stream = AdventDay::class.java.getResourceAsStream(resource) ?: error("Resource not found: $resource")
    return parse(stream.bufferedReader().lineSequence())
}

private data class AdventDay<T>(
    val day: Int,
    val puzzle: Puzzle<T>,
    val parser: InputParser<T>,
    val resource: String
)
