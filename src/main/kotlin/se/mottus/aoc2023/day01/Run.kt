package se.mottus.aoc2023.day01

import se.mottus.util.readResourceAsLines
import kotlin.time.ExperimentalTime
import kotlin.time.measureTimedValue

@ExperimentalTime
fun main() {
    val puzzleinput = readResourceAsLines({}::class.java.`package`.name, "puzzleinput.txt")

    val(result1, time1) = measureTimedValue {part1(puzzleinput)}
    println("Part1 result: $result1, took $time1 ms") // 55017 (20 ms)

    val(result2, time2) = measureTimedValue {part2(puzzleinput)}
    println("Part2 result: $result2, took $time2 ms") // 53539 (20 ms)
}
