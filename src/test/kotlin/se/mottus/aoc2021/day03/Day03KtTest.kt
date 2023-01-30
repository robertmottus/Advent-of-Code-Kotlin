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
    fun mostCommonBitsTest() {
        assertEquals("1100", mostCommonBits(listOf("1101", "1000", "1100")))
        assertEquals("10110", mostCommonBits(testInput))

        println("11001".toInt(2))
    }

    @Test
    fun freq2mostCommonBitTest() {
        assertEquals(1, freqOfOnes2mostCommonBit(9, 5))
        assertEquals(1, freqOfOnes2mostCommonBit(5, 5))
        assertEquals(1, freqOfOnes2mostCommonBit(3, 5))
        assertEquals(0, freqOfOnes2mostCommonBit(2, 5))
        assertEquals(0, freqOfOnes2mostCommonBit(0, 5))
        assertEquals(0, freqOfOnes2mostCommonBit(-1, 5))
    }

}
