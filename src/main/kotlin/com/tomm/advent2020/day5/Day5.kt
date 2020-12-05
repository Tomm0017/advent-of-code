package com.tomm.advent2020.day5

import com.tomm.advent2020.PuzzleStep
import com.tomm.advent2020.day5.Seat.Companion.TOTAL_COLUMNS
import com.tomm.advent2020.day5.Seat.Companion.TOTAL_ROWS

val Day5 = Step1() + Step2()

private class Step1 : PuzzleStep<List<Seat>> {

    override fun solve(input: List<Seat>): String? {
        val highestId = input.maxByOrNull { it.id }
        return highestId?.id?.toString()
    }
}

private class Step2 : PuzzleStep<List<Seat>> {

    override fun solve(input: List<Seat>): String? {
        val ids = input.map { it.id }.toSet()
        val capacity = TOTAL_ROWS * TOTAL_COLUMNS
        for (seat in 1 until capacity - 1) {
            /* skip if seat is occupied */
            if (ids.contains(seat)) continue
            /* condition of our seat is that its `id` + 1 and `id` - 1 are occupied */
            if (ids.contains(seat + 1) && ids.contains(seat - 1)) {
                return seat.toString()
            }
        }
        return null
    }
}
