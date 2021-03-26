package se.mottus.aoc2020.day10.part1

fun part1(puzzleInput: List<String>): Int {
    val inputInts = puzzleInput.map {it.toInt()}.sorted()
    return answerPart1(adapterJoltageDiffs(inputToAdapters(inputInts)))
}

fun inputToAdapters(puzzleInput: List<Int>): List<Int> =
    puzzleInput.plus(0).plus((puzzleInput.maxOrNull()?:0)+3).sorted()

//fun readResource(path:String): List<String> = File(ClassLoader.getSystemResource(path).file).readText().lines()

/**
 * Find a chain that uses all of your adapters to connect the charging outlet to your device's built-in adapter
 * and count the joltage differences between the charging outlet, the adapters, and your device.
 */
fun adapterJoltageDiffs(adapters: List<Int>): Map<Int, Int> =
    adapters.zipWithNext {a1, a2 -> a2-a1}.groupingBy {it}.fold(0) { acc, _->acc.inc()}

/**
 * Part1 question: What is the number of 1-jolt differences multiplied by the number of 3-jolt differences?
 */
fun answerPart1(diffCounts: Map<Int, Int>): Int {
//    val answer = xDiffs.values.reduce{a,b -> a*b} // There are only 1 and 3 diffs, so this also works
    val answer = diffCounts.entries.filter { e -> e.key == 1 || e.key == 3 }.fold(1) { acc, e -> acc * e.value }

    println("Answer: $answer")
    return answer
}


fun foldGroupingByInitialValueSelectorExample() {
    val fruits = listOf("cherry", "blueberry", "citrus", "apple", "apricot", "banana", "coconut")

    val evenFruits = fruits.groupingBy { it.first() }
        .fold({ key, _ -> key to mutableListOf<String>() },
            { _, accumulator, element ->
                accumulator.also { (_, list) -> if (element.length % 2 == 0) list.add(element) }
            })

//    println(evenFruits) // LinkedHashMap Char -> Pair<Char,List<String>>
    val sorted = evenFruits.values.sortedBy { it.first }
    println(sorted) // [(a, []), (b, [banana]), (c, [cherry, citrus])]
}

fun foldGroupingByInitialValueExample() {
    val fruits = listOf("apple", "apricot", "banana", "blueberry", "cherry", "coconut")

// collect only even length Strings
    val evenFruits = fruits.groupingBy { it.first() }
        .fold(listOf<String>()) { acc, e -> if (e.length % 2 == 0) acc + e else acc }

    println(evenFruits) // {a=[], b=[banana], c=[cherry]}  LinkedHashMap Char -> List<String>
}

