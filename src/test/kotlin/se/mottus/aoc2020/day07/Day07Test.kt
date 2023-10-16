package se.mottus.aoc2020.day07

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.mottus.util.readResource

internal class Day07Test {

    @Test
    fun accPart1Test() {
        val input = readResource("se/mottus/aoc2020/day07/puzzleinput.txt")
        assertEquals(103, part1(input))
    }

}