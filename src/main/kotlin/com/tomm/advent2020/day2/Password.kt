package com.tomm.advent2020.day2

import com.tomm.advent2020.InputParser

data class Password(
    val char: Char,
    val range: IntRange,
    val text: String
)

class PasswordListParser : InputParser<List<Password>> {

    override fun parse(input: Sequence<String>): List<Password> {
        val passwords = input.map { line ->
            val rangeIndex = line.indexOf(RANGE_SEPARATOR)
            val charIndex = line.indexOf(PASSWORD_SEPARATOR, rangeIndex)
            val password = line.substring(line.indexOf(WHITESPACE, charIndex) + 1)

            val char = line[charIndex - 1]
            val rangeMinCount = line.substring(0, rangeIndex).toInt()
            val rangeMaxCount = line.substring(rangeIndex + 1, charIndex - 2).toInt()

            Password(char, rangeMinCount..rangeMaxCount, password)
        }
        return passwords.toList()
    }

    companion object {

        private const val WHITESPACE = ' '

        private const val RANGE_SEPARATOR = '-'

        private const val PASSWORD_SEPARATOR = ":"
    }
}
