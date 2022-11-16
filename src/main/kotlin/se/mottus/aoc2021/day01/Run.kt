package se.mottus.aoc2021.day01

import se.mottus.aoc2020.readResource
import kotlin.time.ExperimentalTime
import kotlin.time.measureTimedValue

@ExperimentalTime
fun main() {
    val puzzleinput = readResource({}::class.java.`package`.name, "puzzleinput.txt")

    val(result1, time1) = measureTimedValue {part1(puzzleinput)}
    println("Part1 result: $result1, took $time1 ms") // 1527 (8 ms)

    val(result2, time2) = measureTimedValue {part2(puzzleinput)}
    println("Part2 result: $result2, took $time2 ms") // 1575 (15 ms)
}

