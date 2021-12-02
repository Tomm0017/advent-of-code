package com.tomm.advent2021.day2

import com.tomm.PuzzleStep
import com.tomm.advent2021.day2.movement.DepthMovement
import com.tomm.advent2021.day2.movement.HorizontalMovement
import com.tomm.advent2021.day2.movement.MovementCommand

val Day2 = Step1() + Step2()

private class Step1(private val submarine: Submarine = Submarine()) : PuzzleStep<List<MovementCommand>> {

    override fun solve(input: List<MovementCommand>): String {
        input.forEach { command ->
            if (command is HorizontalMovement) {
                submarine.horizontalPosition += command.steps
            } else if (command is DepthMovement) {
                submarine.depth += command.steps
            }
        }
        val sum = submarine.horizontalPosition * submarine.depth
        return sum.toString()
    }
}

private class Step2(private val submarine: Submarine = Submarine()) : PuzzleStep<List<MovementCommand>> {

    override fun solve(input: List<MovementCommand>): String {
        input.forEach { command ->
            if (command is HorizontalMovement) {
                submarine.horizontalPosition += command.steps
                submarine.depth += submarine.aim * command.steps
            } else if (command is DepthMovement) {
                submarine.aim += command.steps
            }
        }
        val sum = submarine.horizontalPosition * submarine.depth
        return sum.toString()
    }
}
