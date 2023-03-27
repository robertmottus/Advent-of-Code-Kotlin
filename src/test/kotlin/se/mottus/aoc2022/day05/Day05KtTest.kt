package se.mottus.aoc2022.day02

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import se.mottus.aoc2022.day05.executeMoves
import se.mottus.aoc2022.day05.initStacks
import se.mottus.aoc2022.day05.movePart1
import se.mottus.aoc2022.day05.movePart2

internal class Day05KtTest {
    private val testInput = """
            [D]    
        [N] [C]    
        [Z] [M] [P]
         1   2   3 
        
        move 1 from 2 to 1
        move 3 from 1 to 3
        move 2 from 2 to 1
        move 1 from 1 to 2
    """.trimIndent().lines()

    @Test
    fun initStacksTest() {
        val stacks = initStacks(testInput)
        assertEquals(3, stacks.size)
        assertEquals(listOf('Z', 'N'), stacks[0])
        assertEquals(listOf('M', 'C', 'D'), stacks[1])
        assertEquals(listOf('P'), stacks[2])
    }

    @Test
    fun movePart1Test() {
        val stacks = initStacks(testInput)
        movePart1(stacks, 1, 2, 1)
        assertEquals(listOf('Z', 'N', 'D'), stacks[0])
        assertEquals(listOf('M', 'C'), stacks[1])
        assertEquals(listOf('P'), stacks[2])
        movePart1(stacks, 3, 1, 3)
        assertEquals(emptyList<Char>(), stacks[0])
        assertEquals(listOf('M', 'C'), stacks[1])
        assertEquals(listOf('P', 'D', 'N', 'Z'), stacks[2])
    }

    @Test
    fun movePart2Test() {
        val stacks = initStacks(testInput)
        movePart2(stacks, 1, 2, 1)
        assertEquals(listOf('Z', 'N', 'D'), stacks[0])
        assertEquals(listOf('M', 'C'), stacks[1])
        assertEquals(listOf('P'), stacks[2])
        movePart2(stacks, 3, 1, 3)
        assertEquals(emptyList<Char>(), stacks[0])
        assertEquals(listOf('M', 'C'), stacks[1])
        assertEquals(listOf('P', 'Z', 'N', 'D'), stacks[2])
    }

    @Test
    fun executeMovesTest() {
        val stacks = initStacks(testInput)
        executeMoves(stacks, testInput)
        assertEquals(listOf('C'), stacks[0])
        assertEquals(listOf('M'), stacks[1])
        assertEquals(listOf('P', 'D', 'N', 'Z'), stacks[2])
    }

}
