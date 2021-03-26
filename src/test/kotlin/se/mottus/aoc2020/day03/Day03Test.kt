package se.mottus.aoc2020.day03

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.mottus.aoc2020.readResource

internal class Day03Test {

    @Test
    fun accPart1Test() {
        val input = readResource("se/mottus/aoc2020/day03/puzzleinput.txt")
        assertEquals(257, countTrees(input))
    }

    @Test
    fun devPart1Test() {
        val input = readResource("se/mottus/aoc2020/day03/test-puzzleinput.txt")
        assertEquals(7, countTrees(input))
    }

    @Test
    fun accTestPart2Test() {
        val input = readResource("se/mottus/aoc2020/day03/puzzleinput.txt")
        assertEquals(1744787392, countTreesPart2(input))
    }

    @Test
    fun devPart2Test() {
        val input = readResource("se/mottus/aoc2020/day03/test-puzzleinput.txt")
        assertEquals(336, countTreesPart2(input))
    }

    @Test
    fun isTreeTest() {
        val mapOfTrees = mapOf(Point(0,1) to true)

        assertEquals(false, isTree(Point(0,0), mapOfTrees, 1))
        assertEquals(true, isTree(Point(0,1), mapOfTrees, 1))

        assertEquals(true, isTree(Point(1,1), mapOfTrees, 1))
        assertEquals(true, isTree(Point(2,1), mapOfTrees, 1))
        assertEquals(true, isTree(Point(3,1), mapOfTrees, 1))
    }

    @Test
    fun inputToGridTest() {
        assertEquals(mapOf(Point(1,0) to true), inputToMapOfTreePositions(listOf(".#")))
        assertEquals(mapOf(Point(0,1) to true), inputToMapOfTreePositions(listOf("..", "#.")))
    }

    @Test
    fun countTreesTest() {
        assertEquals(1, countTrees(inputToMapOfTreePositions(listOf("..", ".#")), 2, 2))
    }

}