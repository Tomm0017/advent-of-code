package com.tomm.advent2021.util

import java.util.BitSet

class BitList(val size: Int, private val bits: BitSet) {

    fun count(ones: Boolean): Int {
        if (bits.isEmpty) return 0
        var count = 0
        for (i in 0 until size) {
            if (bits[i] == ones) {
                count++
            }
        }
        return count
    }

    operator fun get(index: Int): Boolean {
        return bits[index]
    }

    override fun toString(): String {
        return (0 until size).map { if (bits[it]) "1" else "0" }.toString()
    }
}
