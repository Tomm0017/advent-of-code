package com.tomm.advent2021.util

class Bit(val flag: Boolean) {

    fun toInt(): Int {
        return if (flag) 1 else 0
    }

    fun invert(): Bit {
        return Bit(!flag)
    }
}
