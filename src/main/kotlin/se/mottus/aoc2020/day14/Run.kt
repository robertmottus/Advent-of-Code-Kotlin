package se.mottus.aoc2020.day14

import se.mottus.aoc2020.readResource
import kotlin.time.ExperimentalTime
import kotlin.time.measureTimedValue

// https://adventofcode.com/2020/day/14

@ExperimentalTime
fun main() {
    val puzzleinput = readResource({}::class.java.`package`.name, "puzzleinput.txt")

    runTimelogged("Part1") {part1(puzzleinput)}
}

@ExperimentalTime
fun runTimelogged(blockName: String, block: () -> Unit) {
    val(result, time1) = measureTimedValue(block)
    println("$blockName result: $result, took $time1 ms")
}

