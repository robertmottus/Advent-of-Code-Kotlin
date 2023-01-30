package se.mottus.aoc2021.day03

/**
 * https://adventofcode.com/2021/day/3
 */

fun part1(input: List<String>): Int =
    1


fun mostCommonBits(binaryNumbers: List<String>): String {
    val n = binaryNumbers[0].length
    return binaryNumbers
        .fold(emptyList<Int>()) { a, number -> updateFreqOfOnes(a, number) }
        .fold("") { a, f -> a + freqOfOnes2mostCommonBit(f, n) }
}

fun freqOfOnes2mostCommonBit(freq: Int, n: Int) = if(freq * 2 > n) 1 else 0

fun updateFreqOfOnes(frequencies: List<Int>, number: String): kotlin.collections.List<Int> {
    return frequencies.apply { this }
}


