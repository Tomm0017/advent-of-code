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
    val bits = BitSet(size)
    forEachIndexed { index, flag -> bits[index] = flag }
    return BitList(size, bits)
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
        for (bitPos in 0 until input.columns.size) {
            if (oxygenRows.size > 1) {
                val column = oxygenRows.map { it[bitPos] }.toBitList()
                val mostCommon = column.mostCommonBit()
                oxygenRows = oxygenRows.filter { it[bitPos] == mostCommon.flag }
            }

            if (co2Rows.size > 1) {
                val column = co2Rows.map { it[bitPos] }.toBitList()
                val leastCommon = column.mostCommonBit().invert()
                co2Rows = co2Rows.filter { it[bitPos] == leastCommon.flag }
            }
        }
        val oxygenRating = oxygenRows.firstOrNull()?.toDecimal() ?: error("No valid element found for oxygen rating")
        val co2Rating = co2Rows.firstOrNull()?.toDecimal() ?: error("No valid element found for CO2 rating")
        return (oxygenRating * co2Rating).toString()
    }
}
