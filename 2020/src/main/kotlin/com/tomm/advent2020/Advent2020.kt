package com.tomm.advent2020

import com.tomm.InputParser
import com.tomm.IntListParser
import com.tomm.Puzzle
import com.tomm.advent2020.day1.Day1
import com.tomm.advent2020.day2.Day2
import com.tomm.advent2020.day2.PasswordListParser
import com.tomm.advent2020.day3.Day3
import com.tomm.advent2020.day3.MapParser
import com.tomm.advent2020.day4.Day4
import com.tomm.advent2020.day4.PassportListParser
import com.tomm.advent2020.day5.Day5
import com.tomm.advent2020.day5.SeatListParser
import com.tomm.advent2020.day6.Day6
import com.tomm.advent2020.day6.QuestionnaireParser

fun main() {
    val days = arrayOf(
        AdventDay(1, Day1, IntListParser(), "day1.txt"),
        AdventDay(2, Day2, PasswordListParser(), "day2.txt"),
        AdventDay(3, Day3, MapParser(), "day3.txt"),
        AdventDay(4, Day4, PassportListParser(), "day4.txt"),
        AdventDay(5, Day5, SeatListParser(), "day5.txt"),
        AdventDay(6, Day6, QuestionnaireParser(), "day6.txt")
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

private fun <T> solve(advent: AdventDay<T>) {
    val (day, puzzle, parser, resource) = advent
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
