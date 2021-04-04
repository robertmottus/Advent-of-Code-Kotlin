package se.mottus.aoc2020.day05

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.mottus.aoc2020.readResource

internal class Day05Test {

    @Test
    fun accPart1Test() {
        val input = readResource("se/mottus/aoc2020/day05/puzzleinput.txt")
        assertEquals(828, part1(input))
    }

    @Test
    fun devPart1Test() {
        val input = readResource("se/mottus/aoc2020/day05/test-puzzleinput.txt")
        assertEquals(820, part1(input))
    }

    @Test
    fun seatIdTest() {
        assertEquals(567, seatId(Pair(70,7)))
    }

    @Test
    fun string2SeatTest() {
        assertEquals(Pair(70,7), str2Seat("BFFFBBFRRR"))
    }

    @Test
    fun positionTest() {
        assertEquals(70, position("BFFFBBF", "FB"))
    }

}