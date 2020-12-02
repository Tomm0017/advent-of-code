package com.tomm.advent2020.day1

import com.tomm.advent2020.PuzzleStep
import com.tomm.advent2020.plus

val Day1 = Step1() + Step2()

private const val EXPECTED_SUM = 2020

private class Step1 : PuzzleStep<List<Int>> {

    override fun solve(input: List<Int>): String? {
        for (i in input.indices) {
            for (j in i until input.size) {
                val left = input[i]
                val right = input[j]
                if (left + right == EXPECTED_SUM) {
                    return (left * right).toString()
                }
            }
        }
        return null
    }
}

private class Step2 : PuzzleStep<List<Int>> {

    override fun solve(input: List<Int>): String? {
        for (i in input.indices) {
            for (j in i until input.size) {
                for (k in j until input.size) {
                    val left = input[i]
                    val middle = input[j]
                    val right = input[k]
                    if (left + middle + right == EXPECTED_SUM) {
                        return (left * middle * right).toString()
                    }
                }
            }
        }
        return null
    }
}
