package se.mottus.aoc2020.day10

import se.mottus.aoc2020.day10.part1.part1
import se.mottus.util.readResourceAsLines
import kotlin.time.ExperimentalTime
import kotlin.time.measureTimedValue

@ExperimentalTime
fun main() {
    val puzzleinput = readResourceAsLines({}::class.java.`package`.name, "puzzleinput.txt")

    val(result, time) = measureTimedValue {part1(puzzleinput)}
    println("Part1 $result took $time ms")
}

