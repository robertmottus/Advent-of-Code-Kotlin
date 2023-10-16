package se.mottus.aoc2020.day07

import se.mottus.util.readResource
import kotlin.time.ExperimentalTime
import kotlin.time.measureTimedValue

// https://adventofcode.com/2020/day/7

@ExperimentalTime
fun main() {
    val puzzleinput = readResource({}::class.java.`package`.name, "puzzleinput.txt")

    runTimelogged("Part1 normal") {part1(puzzleinput)}
    runTimelogged("Part1 normal") {part1(puzzleinput)}
}

@ExperimentalTime
fun runTimelogged(blockName: String, block: () -> Unit) {
    val(result, time1) = measureTimedValue(block)
    println("$blockName result: $result, took $time1 ms")
}

