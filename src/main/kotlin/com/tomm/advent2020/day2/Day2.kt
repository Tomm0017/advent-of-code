package com.tomm.advent2020.day2

import com.tomm.advent2020.PuzzleStep

val Day2 = Step1() + Step2()

private class Step1 : PuzzleStep<List<Password>> {

    override fun solve(input: List<Password>): String {
        val count = input.count { password ->
            val (required, requiredRange, text) = password
            text.count { it == required } in requiredRange
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
            char1 == char && char2 != char || char1 != char && char2 == char
        }
        return count.toString()
    }

    companion object {

        private const val INDEX_PADDING_FOR_DUMMIES = 1
    }
}
