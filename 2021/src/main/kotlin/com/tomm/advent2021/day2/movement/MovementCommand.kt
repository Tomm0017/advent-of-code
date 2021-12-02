package com.tomm.advent2021.day2.movement

interface MovementCommand

class HorizontalMovement(val steps: Int) : MovementCommand

class DepthMovement(val steps: Int) : MovementCommand
