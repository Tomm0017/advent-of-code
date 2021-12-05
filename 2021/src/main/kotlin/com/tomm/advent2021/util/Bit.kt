package com.tomm.advent2021.util

class Bit(private val value: Boolean) {

    val bitFlag: Boolean
        get() = value

    fun toInt(): Int {
        return if (value) 1 else 0
    }

    fun invert(): Bit {
        return Bit(!value)
    }
}
