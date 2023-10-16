package se.mottus.aoc2022.day07

import se.mottus.util.readResourceAsLines
import kotlin.time.ExperimentalTime
import kotlin.time.measureTimedValue

@ExperimentalTime
fun main() {
    val puzzleinput = readResourceAsLines({}::class.java.`package`.name, "puzzleinput.txt")

    val(result1, time1) = measureTimedValue {part1(puzzleinput)}
    println("Part1 result: $result1, took $time1 ms") //

}

