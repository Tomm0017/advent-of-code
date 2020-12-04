package com.tomm.advent2020.day4

import com.tomm.advent2020.InputParser

data class Passport(val properties: Map<String, String>)

class PassportListParser : InputParser<List<Passport>> {

    override fun parse(input: Sequence<String>): List<Passport> {
        val passports = mutableListOf<Passport>()
        val properties = mutableMapOf<String, String>()
        input.forEach { line ->
            if (line.isBlank()) {
                passports += Passport(properties.toMap())
                properties.clear()
                return@forEach
            }
            val pairs = regex.findAll(line).toList()
            pairs.forEach { match ->
                val groups = match.groupValues
                val key = groups[1].toLowerCase()
                val value = groups[2]
                if (key.isNotBlank() && value.isNotBlank()) {
                    properties[key] = value
                }
            }
        }
        /* take any pending properties and create a passport */
        if (properties.isNotEmpty()) {
            passports += Passport(properties.toMap())
            properties.clear()
        }
        return passports
    }

    companion object {

        private val regex = Regex("(\\S+):(\\S+)")
    }
}
