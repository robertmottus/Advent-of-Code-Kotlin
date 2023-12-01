package se.mottus.aoc2023.day01

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Day01KtTest {
    // Should result in sum 142
    private val doc1 = """
        1abc2
        pqr3stu8vwx
        a1b2c3d4e5f
        treb7uchet
    """.trimIndent()

    // Should result in sum 281
    private val doc2 = """
        two1nine
        eightwothree
        abcone2threexyz
        xtwone3four
        4nineeightseven2
        zoneight234
        7pqrstsixteen
    """.trimIndent()

    @Test
    fun toNumber1Test() {
        assertEquals(12, toNumber1("a1b2c"))
    }
    @Test
    fun toNumber2Test() {
        assertEquals(76, toNumber2("7pqrstsixteen"))
    }
    @Test
    fun docToSUmOfNumbers1Test() {
        val sum = doc1.lines()
            .map { l -> toNumber1(l) }
            .sum()
        assertEquals(142, sum)
    }

    @Test
    fun docToSUmOfNumbers2Test() {
        val sum = doc2.lines()
            .map { l -> toNumber2(l) }
            .sum()
        assertEquals(281, sum)
    }
}
