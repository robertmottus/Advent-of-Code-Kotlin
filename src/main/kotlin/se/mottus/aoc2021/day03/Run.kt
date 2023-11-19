package se.mottus.aoc2021.day03

import se.mottus.util.readResourceAsLines
import kotlin.time.ExperimentalTime
import kotlin.time.measureTimedValue

@ExperimentalTime
fun main() {
    val puzzleInput = readResourceAsLines({}::class.java.`package`.name, "puzzleinput.txt")

    val(result1, time1) = measureTimedValue {part1(puzzleInput)}
    println("Part1 result: $result1, took $time1 ms") // 4006064 (10 ms)

}
