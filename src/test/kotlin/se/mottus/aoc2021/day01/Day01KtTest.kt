package se.mottus.aoc2021.day01

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Day01KtTest {
    @Test
    fun countIncrementsTest() {
        val depths = listOf(199, 200, 208, 210, 200, 207, 240, 269, 260, 263)
        assertEquals(7, countIncrements(depths))
    }

    @Test
    fun movingSumOfThreeTest() {
        val depths = listOf(199, 200, 208, 210, 200, 207, 240, 269, 260, 263)
        assertEquals(listOf(607, 618, 618, 617, 647, 716, 769, 792), movingSumOfThree(depths))
    }

}
