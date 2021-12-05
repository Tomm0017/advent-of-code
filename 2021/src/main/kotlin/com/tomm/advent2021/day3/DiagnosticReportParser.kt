package com.tomm.advent2021.day3

import com.tomm.InputParser
import com.tomm.advent2021.util.BitList
import java.util.BitSet

class DiagnosticReportParser : InputParser<DiagnosticReport> {

    override fun parse(input: Sequence<String>): DiagnosticReport {
        val inputList = input.toList()
        val width = inputList.first().length
        val length = inputList.count()
        val rows = mutableListOf<BitList>()
        val columns = mutableListOf<BitList>()
        for (row in 0 until width) {
            val columnBits = BitSet(length)
            for (column in 0 until length) {
                val char = inputList[column][row]
                columnBits[column] = char.toBoolean()
            }
            columns += BitList(length, columnBits)
        }
        for (column in 0 until length) {
            val rowBits = BitSet(width)
            for (row in 0 until width) {
                val char = inputList[column][row]
                rowBits[row] = char.toBoolean()
            }
            rows += BitList(width, rowBits)
        }
        return DiagnosticReport(columns = columns, rows = rows)
    }

    private fun Char.toBoolean(): Boolean = when (this) {
        '0' -> false
        '1' -> true
        else -> error("Char '$this' cannot be converted to boolean")
    }
}
