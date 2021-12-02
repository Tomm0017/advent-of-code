package com.tomm

interface InputParser<T> {

    fun parse(input: Sequence<String>): T
}

class IntListParser : InputParser<List<Int>> {

    override fun parse(input: Sequence<String>): List<Int> {
        return input.map { it.toInt() }.toList()
    }
}
