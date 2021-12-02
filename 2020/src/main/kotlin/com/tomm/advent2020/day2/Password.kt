package com.tomm.advent2020.day2

import com.tomm.InputParser

data class Password(
    val char: Char,
    val range: IntRange,
    val text: String
)

class PasswordListParser : InputParser<List<Password>> {

    override fun parse(input: Sequence<String>): List<Password> {
        val passwords = input.map { line ->
            val match = regex.matchEntire(line) ?: error("Invalid line match: $line")
            val values = match.groupValues

            val rangeMin = values[1].toInt()
            val rangeMax = values[2].toInt()
            val char = values[3][0]
            val password = values[4]

            Password(char, rangeMin..rangeMax, password)
        }
        return passwords.toList()
    }

    companion object {

        private val regex = Regex("(\\d+)-(\\d+) (\\w): (\\w+)")
    }
}
