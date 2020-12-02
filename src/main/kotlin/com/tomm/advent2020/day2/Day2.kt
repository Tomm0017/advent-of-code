package com.tomm.advent2020.day2

import com.tomm.advent2020.PuzzleStep

val Day2 = Step1() + Step2()

private class Step1 : PuzzleStep<List<Password>> {

    override fun solve(input: List<Password>): String {
        val count = input.count { password ->
            val (required, range, text) = password
            val count = text.count { it == required }
            count in range
        }
        return count.toString()
    }
}

private class Step2 : PuzzleStep<List<Password>> {

    override fun solve(input: List<Password>): String {
        val count = input.count { password ->
            val (char, range, text) = password
            val char1 = text[range.first - INDEX_PADDING_FOR_DUMMIES]
            val char2 = text[range.last - INDEX_PADDING_FOR_DUMMIES]
            (char1 == char) xor (char2 != char)
        }
        return count.toString()
    }

    companion object {

        private const val INDEX_PADDING_FOR_DUMMIES = 1
    }
}
