package com.tomm.advent2021.day2

import com.tomm.InputParser

interface MovementCommand
class HorizontalMovement(val steps: Int) : MovementCommand
class DepthMovement(val steps: Int) : MovementCommand

class MovementParser : InputParser<List<MovementCommand>> {

    override fun parse(input: Sequence<String>): List<MovementCommand> {
        val commands = input.map { line ->
            val match = regex.matchEntire(line) ?: error("Invalid line match: $line")
            val values = match.groupValues
            val type = values[1]
            val steps = values[2].toInt()
            type.toCommand(steps)
        }
        return commands.toList()
    }

    private fun String.toCommand(steps: Int): MovementCommand = when (this) {
        "forward" -> HorizontalMovement(steps)
        "down" -> DepthMovement(steps)
        "up" -> DepthMovement(-steps)
        else -> error("Invalid command type $this")
    }

    companion object {
        private val regex = Regex("(\\w+) (\\d+)")
    }
}
