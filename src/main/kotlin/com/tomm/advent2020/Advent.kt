package com.tomm.advent2020

import com.tomm.advent2020.day1.Day1

fun main() {
    val days = arrayOf(
        AdventDay(1, Day1, IntListParser(), "day1.txt")
    )
    days.forEach(::solve)
}

private data class AdventDay<T>(
    val day: Int,
    val puzzle: Puzzle<T>,
    val parser: InputParser<T>,
    val resources: String
)

private fun <T> solve(advent: AdventDay<T>) {
    val (day, puzzle, parser, resource) = advent
    solve(day, puzzle, parser, resource)
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

private fun <T> InputParser<T>.parse(resource: String): T {
    InputParser::class.java.getResourceAsStream(resource).use { stream ->
        return parse(stream.bufferedReader().lineSequence())
    }
}
