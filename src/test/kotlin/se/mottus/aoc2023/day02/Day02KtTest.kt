package se.mottus.aoc2023.day02

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Day02KtTest {

    @Test
    fun validSetTest() {
        assertEquals(true,  isValidSet(toSetMap("3 blue, 4 red")))
        assertEquals(false,  isValidSet(toSetMap("3 blue, 42 red")))
    }

    @Test
    fun validGameTest() {
        assertEquals(true,  isValidGame("3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green"))
        assertEquals(false,  isValidGame("8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red"))
    }

}
