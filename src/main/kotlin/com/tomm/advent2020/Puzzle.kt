package com.tomm.advent2020

data class Puzzle<T>(
    val steps: List<PuzzleStep<T>>
)

interface PuzzleStep<T> {

    fun solve(input: T): String?
}

operator fun <T> PuzzleStep<T>.plus(other: PuzzleStep<T>): Puzzle<T> {
    return Puzzle(listOf(this, other))
}
