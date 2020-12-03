package com.tomm.advent2020.day3

import com.tomm.advent2020.InputParser

data class Tree(val x: Int, val y: Int)

data class Map(val width: Int, val length: Int, val trees: List<Tree>)

class MapParser : InputParser<Map> {

    override fun parse(input: Sequence<String>): Map {
        val lines = input.toList()
        val width = lines.maxOf { it.length }
        val length = lines.count()
        val trees = mutableListOf<Tree>()
        lines.forEachIndexed { y, line ->
            line.forEachIndexed { x, char ->
                if (char == TREE_CHAR) {
                    val tree = Tree(x, y)
                    trees.add(tree)
                }
            }
        }
        return Map(width, length, trees)
    }

    companion object {

        private const val TREE_CHAR = '#'
    }
}
