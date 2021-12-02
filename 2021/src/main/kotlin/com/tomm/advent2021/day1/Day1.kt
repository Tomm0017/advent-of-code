package com.tomm.advent2021.day1

import com.tomm.PuzzleStep

val Day1 = Step1() + Step2()

private class Step1 : PuzzleStep<List<Int>> {

    override fun solve(input: List<Int>): String {
        return input.zipWithNext().count { (a, b) -> b > a }.toString()
    }
}

private class Step2 : PuzzleStep<List<Int>> {

    override fun solve(input: List<Int>): String {
        val windowed = input.windowed(WINDOW_SIZE)
        return Step1().solve(windowed.map(List<Int>::sum))
    }

    companion object {
        private const val WINDOW_SIZE = 3
    }
}
