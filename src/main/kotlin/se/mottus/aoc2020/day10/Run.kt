package se.mottus.aoc2020.day10

import se.mottus.aoc2020.day10.part1.part1
import se.mottus.aoc2020.readResource
import kotlin.time.ExperimentalTime
import kotlin.time.measureTimedValue

@ExperimentalTime
fun main() {
    val puzzleinput = readResource({}::class.java.`package`.name, "puzzleinput.txt")

    val(result, time) = measureTimedValue {part1(puzzleinput)}
    println("Part1 $result took $time ms")
}

