package se.mottus.aoc2021.day01

/**
 * https://adventofcode.com/2021/day/1
 */
fun part1(input: List<String>): Int =
    countIncrements(toInts(input))

fun part2(input: List<String>): Int =
    countIncrements(movingSumOfThree(toInts(input)))

fun toInts(strings: List<String>) = strings.map {it.toInt()}

fun countIncrements(depths: List<Int>): Int =
    depths.zipWithNext {d1, d2 -> if (d1 < d2) 1 else 0}.sum()

fun movingSumOfThree(depths: List<Int>): List<Int> {
    return depths.windowed(3,1)  {it.reduce {a,b -> a+b}}
}
