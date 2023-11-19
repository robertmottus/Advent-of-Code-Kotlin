package se.mottus.aoc2021.day03

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Day03KtTest {
    val testInput = listOf(
        "00100",
        "11110",
        "10110",
        "10111",
        "10101",
        "01111",
        "00111",
        "11100",
        "10000",
        "11001",
        "00010",
        "01010"
    )

    @Test
    fun mostCommonBitTest() {
        assertEquals("1100", mostCommonBits(listOf("1101", "1000", "1100")))
        assertEquals("0011", mostCommonBits(listOf("1101", "1000", "1100"), true))

        assertEquals("10110", mostCommonBits(testInput))
        assertEquals("01001", mostCommonBits(testInput, true))
    }

}
