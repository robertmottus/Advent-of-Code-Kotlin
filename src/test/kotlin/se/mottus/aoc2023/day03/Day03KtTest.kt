package se.mottus.aoc2023.day03

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test


internal class Day03KtTest {

    private val schema = """
        467..114..
        ...*......
        ..35..633.
        ......#...
        617*......
        .....+.58.
        ..592.....
        ......755.
        ...$.*....
        .664.598..
    """.trimIndent().lines()

    @Test
    fun part1Test() {
        assertEquals(4361, part1(schema))
    }

    @Test
    fun parseSymbolsTest() {
        val symbols = parseSymbols(schema)
        assertEquals(6, symbols.size)
        assertEquals(Coordinate(3,1), symbols.first())
        assertEquals(Coordinate(5,8), symbols.last())
        assertEquals(true, symbols.contains(Coordinate(3,4)))
    }

    @Test
    fun parsePartNumbersTest() {
        val symbols = parseSymbols(schema)
        val partNumbers = parsePartNumbers(schema,symbols)
        assertEquals(8, partNumbers.size)
    }

    @Test
    fun isPartNumberTest() {
        val symbols = parseSymbols(schema)
        // Number with symbol as neighbour is a PartNumber
        //  467..114..
        //  ...*......
        //     PartNumber: 467, x:0 y:0
        // Not PartNumber: 114, x:5 y:0
        assertEquals(true, isPartNumber(Coordinate(0,0),467, maxCoordinate(schema), symbols))
        assertEquals(false, isPartNumber(Coordinate(5,0),114, maxCoordinate(schema), symbols))
    }

    @Test
    fun regexTest() {
        // https://www.baeldung.com/kotlin/regular-expressions

        val regexNumber = """\d+""".toRegex()

        assertTrue(regexNumber.matches("35"))
        assertFalse(regexNumber matches "abc633")
        assertTrue(regexNumber.containsMatchIn("abc633abc"))

        // First match
        val matchResult = regexNumber.find("..35..633.")
        assertEquals("35", matchResult!!.value)

        // All matches
        val matchResults = regexNumber.findAll("..35..633.")
        assertEquals("633", matchResults.last().value)
    }
}

