package se.mottus.aoc2022.day02

import se.mottus.aoc2022.day02.Outcome.*
import se.mottus.aoc2022.day02.Shape.*

/**
 * https://adventofcode.com/2022/day/2
 */
fun part1(input: List<String>): Int =
    linesToScore(input)

enum class Shape {
    ROCK, PAPER,  SCISSORS
}

enum class Outcome {
    LOST, DRAW, WON
}

class Round(val opponentShape: Shape, val myShape: Shape) {
    fun myOutcome() : Outcome=
        when {
            opponentShape == myShape -> DRAW
            opponentShape == ROCK && myShape == PAPER -> WON
            opponentShape == PAPER && myShape == SCISSORS -> WON
            opponentShape == SCISSORS && myShape == ROCK -> WON
            else -> LOST
        }
}

fun shape(string: String): Shape =
    when(string) {
        "A" -> ROCK
        "B" -> PAPER
        "C" -> SCISSORS
        else -> throw IllegalArgumentException("Unknown: $string")
    }

fun shapePart1(string: String): Shape =
    when(string) {
        "X" -> ROCK
        "Y" -> PAPER
        "Z" -> SCISSORS
        else -> throw IllegalArgumentException("Unknown: $string")
    }

fun linesToScore(line: List<String>): Int =
    line.map { lineToRound(it) }
        .sumOf { score(it) }

fun lineToRound(line: String): Round =
    line.split(" ").let {
            Round(shape(it[0]), shapePart1(it[1]))
        }

fun score(round: Round) =  score(round.myOutcome()) + score(round.myShape)


// score for the shape you selected (1 for Rock, 2 for Paper, and 3 for Scissors)
fun score(shape: Shape) =
    when(shape) {
        ROCK -> 1
        PAPER -> 2
        SCISSORS -> 3
    }

// score for the outcome of the round (0 if you lost, 3 if the round was a draw, and 6 if you won)
fun score(outcome: Outcome) =
    when(outcome) {
        LOST -> 0
        DRAW -> 3
        WON -> 6
    }

