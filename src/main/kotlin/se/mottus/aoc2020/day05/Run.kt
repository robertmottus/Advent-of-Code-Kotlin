package se.mottus.aoc2020.day05

import se.mottus.util.readResourceAsLines
import kotlin.time.ExperimentalTime
import kotlin.time.measureTimedValue

// https://adventofcode.com/2020/day/5

@ExperimentalTime
fun main() {
    val puzzleinput = readResourceAsLines({}::class.java.`package`.name, "puzzleinput.txt")

    runTimelogged("Part1 normal") {part1(puzzleinput)}
    runTimelogged("Part1 normal") {part1(puzzleinput)}
    runTimelogged("Part1 optim ") {part1_optimized(puzzleinput) }
    runTimelogged("Part1 optim ") {part1_optimized(puzzleinput) }

    runTimelogged("Part2") {part2(puzzleinput)}
    runTimelogged("Part2") {part2(puzzleinput)}
}

@ExperimentalTime
fun runTimelogged(blockName: String, block: () -> Unit) {
    val(result, time1) = measureTimedValue(block)
    println("$blockName result: $result, took $time1 ms")
}

