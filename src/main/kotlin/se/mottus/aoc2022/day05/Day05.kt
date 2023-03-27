package se.mottus.aoc2022.day05

/**
 * https://adventofcode.com/2022/day/5
 */

fun initStacks(lines: List<String>): Array<MutableList<Char>> {
    //     [D]
    // [N] [C]
    // [Z] [M] [P]
    //  1   2   3
    val cratesPerLine = lines.filter {l -> l.contains("1")}
        .first().trim().split(regex = "\\s+".toRegex()).size

    val stacks = Array<MutableList<Char>>(cratesPerLine) { mutableListOf() }

    for (line in lines) {
        if (line.contains("1")) break
        val crates = line.chunked(4)
        for (i in 0 until crates.size) {
            crates[i].filter { it.isLetter() }.apply { if (this.isNotBlank()) stacks[i].add(0, this.first()) }
        }
    }
    return stacks
}

fun movePart1(stacks: Array<MutableList<Char>>, count: Int, from: Int, to: Int) {
    for(i in 1..count) {
        val crate = stacks[from-1].removeLast()
        stacks[to-1].add(crate)
    }
}

fun movePart2(stacks: Array<MutableList<Char>>, count: Int, from: Int, to: Int) {
    val crates = mutableListOf<Char>()
    for(i in 1..count) {
        crates.add(stacks[from-1].removeLast())
    }
    stacks[to-1].addAll(crates.asReversed())
}

fun executeMoves(stacks: Array<MutableList<Char>>, lines: List<String>, part1: Boolean = true) {
    //         move 1 from 2 to 1
    for (line in lines) {
        if (!line.contains("move")) continue
        val regex = "(move|from|to)".toRegex()
        val args = regex.split(line.trim()).toTypedArray()
        // args[0] is empty string before "move"

        if(part1)
            movePart1(stacks, trim(args[1]), trim(args[2]), trim(args[3]))
        else
            movePart2(stacks, trim(args[1]), trim(args[2]), trim(args[3]))
    }
}

fun trim(str: String) = str.trim().toInt()

fun part1(input: List<String>): String {
    val stacks = initStacks(input)
    executeMoves(stacks, input)
    return stacks.map { c -> c.last() }.joinToString("")
}

fun part2(input: List<String>): String {
    val stacks = initStacks(input)
    executeMoves(stacks, input, false)
    return stacks.map { c -> c.last() }.joinToString("")
}
