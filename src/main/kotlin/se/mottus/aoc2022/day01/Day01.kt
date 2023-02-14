package se.mottus.aoc2022.day01

/**
 * https://adventofcode.com/2022/day/1
 */
fun part1(input: String): Int =
    sumCalories(input).maxOrNull()!!

fun part2(input: String): Int =
    sumCalories(input).sorted().takeLast(3).sum()

fun sumCalories(cargoes: String): List<Int> =
    cargoes
        .split("\r\n\r\n")
        .map {
            it
                .split("\r\n").sumOf { it.toInt() }
        }
