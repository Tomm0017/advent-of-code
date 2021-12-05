package com.tomm.advent2021.day3

import com.tomm.PuzzleStep
import com.tomm.advent2021.util.Bit
import com.tomm.advent2021.util.BitList
import java.util.BitSet

val Day3 = Part1() + Part2()

private fun BitList.mostCommonBit() = filterBit { ones, zeroes -> ones >= zeroes }

private fun BitList.filterBit(predicate: (Int, Int) -> Boolean): Bit {
    val ones = count(ones = true)
    val zeroes = size - ones
    val flag = predicate(ones, zeroes)
    return Bit(flag)
}

private fun BitList.toDecimal(): Int {
    var value = 0
    for (i in 0 until size) {
        value = (value shl 1) or if (this[i]) 1 else 0
    }
    return value
}

private fun List<Boolean>.toBitList(): BitList {
    val set = BitSet(size)
    forEachIndexed { index, flag -> set[index] = flag }
    return BitList(size, set)
}

private class Part1 : PuzzleStep<DiagnosticReport> {

    override fun solve(input: DiagnosticReport): String {
        var gamma = 0
        var epsilon = 0
        input.columns.forEach { column ->
            val mostCommon = column.mostCommonBit()
            val leastCommon = mostCommon.invert()
            gamma = (gamma shl 1) or mostCommon.toInt()
            epsilon = (epsilon shl 1) or leastCommon.toInt()
        }
        val powerConsumption = gamma * epsilon
        return powerConsumption.toString()
    }
}

private class Part2 : PuzzleStep<DiagnosticReport> {

    override fun solve(input: DiagnosticReport): String {
        var oxygenRows = input.rows.toList()
        var co2Rows = input.rows.toList()
        for (i in 0 until input.columns.size) {
            val oxygenColumn = oxygenRows.map { it[i] }.toBitList()
            val mostCommon = oxygenColumn.mostCommonBit()
            if (oxygenRows.size > 1) {
                oxygenRows = oxygenRows.filter { it[i] == mostCommon.bitFlag }
            }

            val co2Column = co2Rows.map { it[i] }.toBitList()
            val leastCommon = co2Column.mostCommonBit().invert()
            if (co2Rows.size > 1) {
                co2Rows = co2Rows.filter { it[i] == leastCommon.bitFlag }
            }
        }
        val oxygenRating = oxygenRows.firstOrNull()?.toDecimal() ?: error("No valid element found for oxygen rating")
        val co2Rating = co2Rows.firstOrNull()?.toDecimal() ?: error("No valid element found for CO2 rating")
        return (oxygenRating * co2Rating).toString()
    }
}

