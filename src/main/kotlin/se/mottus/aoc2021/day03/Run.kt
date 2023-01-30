package se.mottus.aoc2021.day02

import se.mottus.aoc2020.readResource
import kotlin.time.ExperimentalTime
import kotlin.time.measureTimedValue

@ExperimentalTime
fun main() {
    val puzzleInput = readResource({}::class.java.`package`.name, "puzzleinput.txt")

    val(result1, time1) = measureTimedValue {part1(puzzleInput)}
    println("Part1 result: $result1, took $time1 ms") // 1727835 (10 ms)

    val(result2, time2) = measureTimedValue {part2(puzzleInput)}
    println("Part2 result: $result2, took $time2 ms") // 1544000595 (3 ms)
}
