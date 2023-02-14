package se.mottus.aoc2022.day02

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Day02KtTest {
    private val testInput = """
        A Y
        B X
        C Z
    """.trimIndent().lines()


    @Test
    fun inputLinesToScorePart1Test() {
        assertEquals(15, linesToScoresPart1(testInput))
    }

    @Test
    fun inputLinesToScorePart2Test() {
        assertEquals(12, linesToScoresPart2(testInput))
    }

    @Test
    fun stringToShapeTest() {
        // A for Rock, B for Paper, and C for Scissors
        assertEquals(Shape.ROCK, shape("A"))
        assertEquals(Shape.PAPER, shape("B"))
        assertEquals(Shape.SCISSORS, shape("C"))
    }

    @Test
    fun stringPart1ToShapeTest() {
        // X for Rock, Y for Paper, and Z for Scissors in Part 1
        assertEquals(Shape.ROCK, myShapePart1("X"))
        assertEquals(Shape.PAPER, myShapePart1("Y"))
        assertEquals(Shape.SCISSORS, myShapePart1("Z"))
    }

    @Test
    fun roundScoreTest() {
        // 1 for Rock, 2 for Paper, and 3 for Scissors
        // 0 if you lost, 3 if the round was a draw, and 6 if you won
        assertEquals(1+6, score(Round(Shape.SCISSORS, Shape.ROCK)))
        assertEquals(1+3, score(Round(Shape.ROCK, Shape.ROCK)))
        assertEquals(1+0, score(Round(Shape.PAPER, Shape.ROCK)))
        assertEquals(2+6, score(Round(Shape.ROCK, Shape.PAPER)))
        assertEquals(2+3, score(Round(Shape.PAPER, Shape.PAPER)))
        assertEquals(2+0, score(Round(Shape.SCISSORS, Shape.PAPER)))
        assertEquals(3+6, score(Round(Shape.PAPER, Shape.SCISSORS)))
        assertEquals(3+3, score(Round(Shape.SCISSORS, Shape.SCISSORS)))
        assertEquals(3+0, score(Round(Shape.ROCK, Shape.SCISSORS)))
    }

}
