package se.mottus.aoc2022.day01

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Day01KtTest {
    private val cargoes = "1000\r\n2000\r\n3000\r\n\r\n4000\r\n\r\n5000\r\n6000\r\n\r\n7000\r\n8000\r\n9000\r\n\r\n10000"
    @Test
    fun sumCaloriesTest() {
        assertEquals(listOf(6000, 4000, 11000, 24000, 10000), sumCalories(cargoes))
    }

    @Test
    fun maxCaloriesTest() {
        assertEquals(24000, listOf(6000, 4000, 11000, 24000, 10000).maxOrNull())
        assertEquals(24000, part1(cargoes))
    }

    @Test
    fun sumMax3CaloriesTest() {
        assertEquals(45000, listOf(6000, 4000, 11000, 24000, 10000).sorted().takeLast(3).sum())
        assertEquals(45000, part2(cargoes))
    }

}
