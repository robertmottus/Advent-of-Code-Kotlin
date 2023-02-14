package se.mottus.aoc2022.day01

import se.mottus.util.readResource
import kotlin.time.ExperimentalTime
import kotlin.time.measureTimedValue

@ExperimentalTime
fun main() {
    val puzzleinput = readResource({}::class.java.`package`.name, "puzzleinput.txt")

    val(result1, time1) = measureTimedValue {part1(puzzleinput)}
    println("Part1 result: $result1, took $time1 ms") // 24000 (60 ms)

    val(result2, time2) = measureTimedValue {part2(puzzleinput)}
    println("Part2 result: $result2, took $time2 ms") // 45000 (15 ms)
}

