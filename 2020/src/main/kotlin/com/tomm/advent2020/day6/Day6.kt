package com.tomm.advent2020.day6

import com.tomm.PuzzleStep

val Day6 = Step1() + Step2()

private class Step1 : PuzzleStep<List<Questionnaire>> {

    override fun solve(input: List<Questionnaire>): String {
        val count = input.sumBy { it.uniqueAnswers().size }
        return count.toString()
    }
}

private class Step2 : PuzzleStep<List<Questionnaire>> {

    override fun solve(input: List<Questionnaire>): String {
        val count = input.sumBy { it.unanimousAnswers().size }
        return count.toString()
    }
}

private fun Questionnaire.uniqueAnswers(): Set<Char> {
    return answers.reduce { acc, set -> acc union set }
}

private fun Questionnaire.unanimousAnswers(): Set<Char> {
    return answers.reduce { acc, set -> acc intersect set }
}
