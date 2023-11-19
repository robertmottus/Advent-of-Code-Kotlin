package se.mottus.aoc2021.day03

/**
 * https://adventofcode.com/2021/day/3
 */

fun part1(input: List<String>): Int =
    mostCommonBits(input).toInt(2) * mostCommonBits(input, false).toInt(2)

fun mostCommonBits(input: List<String>, invertToLeastCommonBits: Boolean = false): String =
    input[0].indices
        .map {input.fold(0) {a, row -> a + (row[it] - '0') } }
        .map { if(it * 2 > input.size) 1 else 0 }
        .map { if(invertToLeastCommonBits) 1 - it else it }
        .joinToString("")

fun freqOfOnes2mostCommonBit(freq: Int, n: Int) = if(freq * 2 > n) 1 else 0



