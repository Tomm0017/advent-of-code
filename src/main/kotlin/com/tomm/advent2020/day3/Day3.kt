package com.tomm.advent2020.day3

import com.tomm.advent2020.PuzzleStep

val Day3 = Step1() + Step2()

private class Step1 : PuzzleStep<Map> {

    override fun solve(input: Map): String {
        val count = input.treeCount(SLOPE_X, SLOPE_Y)
        return count.toString()
    }

    companion object {

        private const val SLOPE_X = 3
        private const val SLOPE_Y = 1
    }
}

private class Step2 : PuzzleStep<Map> {

    override fun solve(input: Map): String {
        val slopes = slopes.map { input.treeCount(it.first, it.second).toLong() }
        val count = slopes.reduceRight { i, acc -> acc * i }
        return count.toString()
    }

    companion object {

        private val slopes = arrayOf(
            1 to 1,
            3 to 1,
            5 to 1,
            7 to 1,
            1 to 2
        )
    }
}

private fun Map.trees(slopeX: Int, slopeY: Int): List<Tree> {
    val trees = mutableListOf<Tree>()
    var x = 0
    var y = 0
    while (y < length) {
        val tree = treeAt(x, y)
        tree?.let { trees.add(it) }
        x += slopeX
        y += slopeY
    }
    return trees
}

private fun Map.treeCount(slopeX: Int, slopeY: Int): Int {
    val trees = trees(slopeX, slopeY)
    return trees.size
}

private fun Map.treeAt(x: Int, y: Int): Tree? {
    val lx = x % width
    return trees.firstOrNull { it.x == lx && it.y == y }
}
