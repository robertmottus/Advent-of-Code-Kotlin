package se.mottus.aoc2020.day05

import se.mottus.aoc2020.readResource
import kotlin.time.ExperimentalTime
import kotlin.time.measureTimedValue

// https://adventofcode.com/2020/day/5

@ExperimentalTime
fun main() {
    val puzzleinput = readResource({}::class.java.`package`.name, "puzzleinput.txt")

    val(result1, time1) = measureTimedValue {part1(puzzleinput)}
    println("Part1 result: $result1, took $time1 ms")

    val(result2, time2) = measureTimedValue { part2(puzzleinput) }
    println("Part2 result: $result2, took $time2 ms")
}

