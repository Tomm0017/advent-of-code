package com.tomm.advent2020.day5

import com.tomm.advent2020.InputParser
import com.tomm.advent2020.day5.Seat.Companion.TOTAL_COLUMNS
import com.tomm.advent2020.day5.Seat.Companion.TOTAL_ROWS

data class Seat(
    val row: Int,
    val column: Int
) {

    val id: Int
        get() = id(row, column)

    companion object {

        const val TOTAL_ROWS = 127 /* zero counts as a row */
        const val TOTAL_COLUMNS = 7 /* zero counts as a column */

        fun id(row: Int, column: Int): Int {
            return row * (TOTAL_COLUMNS + 1) + column
        }
    }
}

class SeatListParser : InputParser<List<Seat>> {

    override fun parse(input: Sequence<String>): List<Seat> {
        val seats = mutableListOf<Seat>()
        input.forEach { line ->
            if (line.isBlank()) return@forEach
            val verticalInput = line.substring(0, 7)
            val horizontalInput = line.substring(7)
            val verticalBounds = bounds(verticalInput)
            val horizontalBounds = bounds(horizontalInput)
            val seat = toSeat(verticalBounds, horizontalBounds)
            seats.add(seat)
        }
        return seats
    }

    private fun toSeat(vertical: List<Bound>, horizontal: List<Bound>): Seat {
        val row = vertical.deduce(TOTAL_ROWS)
        val column = horizontal.deduce(TOTAL_COLUMNS)
        return Seat(row, column)
    }

    private fun bounds(input: String): List<Bound> {
        val bounds = mutableListOf<Bound>()
        input.forEach { char ->
            val bound = when (char) {
                'F', 'L' -> Bound.Lower
                'B', 'R' -> Bound.Upper
                else -> Bound.Undefined
            }
            bounds.add(bound)
        }
        return bounds
    }

    private fun List<Bound>.deduce(capacity: Int): Int {
        var deduced = 0..capacity
        forEach { bound ->
            val range = when (bound) {
                Bound.Lower -> deduced.lower()
                Bound.Upper -> deduced.upper()
                else -> error("Invalid bound: $bound")
            }
            deduced = range
        }
        return if (last() == Bound.Upper) {
            deduced.last
        } else {
            deduced.first
        }
    }

    private fun IntRange.lower(): IntRange = first..center

    private fun IntRange.upper(): IntRange = (center + 1)..endInclusive

    private val IntRange.center: Int
        get() = (first + endInclusive) / 2
}

private sealed class Bound {
    object Undefined : Bound()
    object Upper : Bound()
    object Lower : Bound()

    override fun toString(): String = javaClass.simpleName
}
