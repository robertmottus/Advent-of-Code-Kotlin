package se.mottus.aoc2021.day02

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Day02KtTest {
    @Test
    fun move2PositionTest() {
        assertEquals(Position(5,0), move2Position("forward 5"))
        assertEquals(Position(0,5), move2Position("down 5"))
        assertEquals(Position(0,-3), move2Position("up 3"))

        assertThrows(IllegalArgumentException::class.java) { move2Position("X 3") }
    }

    @Test
    fun positionAndAimTest() {
        assertEquals(PositionAndAim(3,4, 2), PositionAndAim(2,2, 2).execute("forward 1"))
        assertEquals(PositionAndAim(2,2, 1), PositionAndAim(2,2, 2).execute("up 1"))
        assertEquals(PositionAndAim(2,2, 3), PositionAndAim(2,2, 2).execute("down 1"))

        assertThrows(IllegalArgumentException::class.java) { PositionAndAim(0,0,0).execute("X 3") }
    }

    @Test
    fun moves2PositionTest() {
        val moves = listOf("forward 5", "down 5", "forward 8", "up 3", "down 8", "forward 2")
        assertEquals(Position(15,10), moves2Position(moves))
    }

    @Test
    fun moves2PositionAndAimTest() {
        val moves = listOf("forward 5", "down 5", "forward 8", "up 3", "down 8", "forward 2")
        assertEquals(PositionAndAim(15,60,10), actions2PositionAndAim(moves))
    }

}
