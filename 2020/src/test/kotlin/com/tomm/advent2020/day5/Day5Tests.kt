package com.tomm.advent2020.day5

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day5Tests {

    @Test
    fun testPart1SinglePass() {
        val input = SeatListParser().parse(sequenceOf("FBFBBFFRLR"))
        val seat = input.firstOrNull()
        Assertions.assertNotNull(seat)
        Assertions.assertEquals(44, seat?.row)
        Assertions.assertEquals(5, seat?.column)
    }

    @Test
    fun testPart1MultiplePasses() {
        val input = SeatListParser().parse(sequenceOf(
            "BFFFBBFRRR",
            "FFFBBBFRRR",
            "BBFFBBFRLL"
        ))
        Assertions.assertEquals(3, input.size)

        /* first seat assertions */
        Assertions.assertEquals(70, input[0].row)
        Assertions.assertEquals(7, input[0].column)
        Assertions.assertEquals(567, input[0].id)

        /* second seat assertions */
        Assertions.assertEquals(14, input[1].row)
        Assertions.assertEquals(7, input[1].column)
        Assertions.assertEquals(119, input[1].id)

        /* third seat assertions */
        Assertions.assertEquals(102, input[2].row)
        Assertions.assertEquals(4, input[2].column)
        Assertions.assertEquals(820, input[2].id)
    }
}
