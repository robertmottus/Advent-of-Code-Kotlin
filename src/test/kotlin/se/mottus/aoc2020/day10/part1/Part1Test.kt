package se.mottus.aoc2020.day10.part1

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import se.mottus.util.readResourceAsLines

internal class Part1Test {

    @Test
    fun devPart1Test() {
        val x = listOf(28,33,18,42,31,14,46,20,48,47,24,23,49,45,19,38,39,11,1,32,25,35,8,17,7,9,4,2,34,10,3)
        val diffs = adapterJoltageDiffs(inputToAdapters(x))
        assertEquals(220, answerPart1(diffs))
    }

    @Test
    fun accPart1Test2() {
        val diffs = adapterJoltageDiffs(inputToAdapters(puzzleInput()))
        assertEquals(1820, answerPart1(diffs))
    }

    @Test
    fun accPart1Test() {
        val puzzleinput = readResourceAsLines("se/mottus/aoc2020/day10/puzzleinput.txt")
        assertEquals(1820, part1(puzzleinput))
    }

    private fun puzzleInput():List<Int> {
        return listOf(17,110,146,144,70,57,124,121,134,12,135,120,19,92,6,103,46,56,93,65,14,31,63,41,131,60,73,83,71,37,85,79,13,7,109,24,94,2,30,3,27,77,91,106,123,128,35,26,112,55,97,21,100,88,113,117,25,82,129,66,11,116,64,78,38,99,130,84,98,72,50,36,54,8,34,20,127,1,137,143,76,69,111,136,53,43,140,145,49,122,18,42)
    }


    // Lab code
    @Test
    fun foldGroupingByInitialValueExampleTest() {
        foldGroupingByInitialValueExample()
    }

    @Test
    fun foldGroupingByInitialValueSelectorExampleTest() {
        foldGroupingByInitialValueSelectorExample()
    }
}