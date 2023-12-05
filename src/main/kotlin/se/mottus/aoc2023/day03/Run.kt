package se.mottus.aoc2023.day03

import se.mottus.util.readResourceAsLines
import kotlin.time.ExperimentalTime
import kotlin.time.measureTimedValue

@ExperimentalTime
fun main() {
    val puzzleInput = readResourceAsLines({}::class.java.`package`.name, "puzzleinput.txt")

    val(result1, time1) = measureTimedValue {part1(puzzleInput)}
    println("Part1 result: $result1, took $time1 ms") // 522726 (60 ms)

//    val(result2, time2) = measureTimedValue {part2(puzzleInput)}
//    println("Part2 result: $result2, took $time2 ms") // 53539 (20 ms)
}
