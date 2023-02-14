package se.mottus.aoc2022.day02

import se.mottus.aoc2022.day02.Outcome.*
import se.mottus.aoc2022.day02.Shape.*

/**
 * https://adventofcode.com/2022/day/2
 */
fun part1(input: List<String>): Int =
    linesToScoresPart1(input)

fun part2(input: List<String>): Int =
    linesToScoresPart2(input)

enum class Shape {
    ROCK, PAPER,  SCISSORS
}

enum class Outcome {
    LOSE, DRAW, WIN
}

class Round(private val opponentShape: Shape, val myShape: Shape) {
    fun myOutcome() : Outcome=
        when {
            opponentShape == myShape -> DRAW
            opponentShape == ROCK && myShape == PAPER -> WIN
            opponentShape == PAPER && myShape == SCISSORS -> WIN
            opponentShape == SCISSORS && myShape == ROCK -> WIN
            else -> LOSE
        }
}

fun calculateMyShape(opponentShape: Shape, outcome: Outcome) =
    when(opponentShape) {
        ROCK -> when(outcome) {
            LOSE -> SCISSORS
            DRAW -> ROCK
            WIN -> PAPER
        }
        PAPER -> when(outcome) {
            LOSE -> ROCK
            DRAW -> PAPER
            WIN -> SCISSORS
        }
        SCISSORS -> when(outcome) {
            LOSE -> PAPER
            DRAW -> SCISSORS
            WIN -> ROCK
        }
    }

fun shape(string: String): Shape =
    when(string) {
        "A" -> ROCK
        "B" -> PAPER
        "C" -> SCISSORS
        else -> throw IllegalArgumentException("Unknown: $string")
    }

// Part 1: [my shape must be] X for Rock, Y for Paper, and Z for Scissors
fun myShapePart1(string: String): Shape =
    when(string) {
        "X" -> ROCK
        "Y" -> PAPER
        "Z" -> SCISSORS
        else -> throw IllegalArgumentException("Unknown: $string")
    }

// Part 2: X means you need to lose, Y means you need to end the round in a draw, and Z means you need to win
fun outcomePart2(string: String): Outcome =
    when(string) {
        "X" -> LOSE
        "Y" -> DRAW
        "Z" -> WIN
        else -> throw IllegalArgumentException("Unknown: $string")
    }

fun linesToScoresPart1(line: List<String>): Int =
    line.map {
        it.split(" ").let {
            val opponentShape = shape(it[0])
            val myShape = myShapePart1(it[1])
            Round(opponentShape, myShape)}}
        .sumOf { score(it) }

fun linesToScoresPart2(line: List<String>): Int =
    line.map {
        it.split(" ").let {
            val opponentShape = shape(it[0])
            val myShape = calculateMyShape(opponentShape, outcomePart2(it[1]))
            Round(opponentShape, myShape)}}
        .sumOf { score(it) }

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
        LOSE -> 0
        DRAW -> 3
        WIN -> 6
    }

