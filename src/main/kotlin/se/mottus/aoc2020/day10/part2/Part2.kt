package se.mottus.aoc2020.day10.part2

import java.lang.IllegalArgumentException
import java.math.BigInteger

fun isValidAdapterArrangement(adaptersSorted: List<Int>): Boolean {
    if (adaptersSorted.first() != 0) throw IllegalArgumentException("First element must be 0")
    return 0 < adaptersSorted.reduce { a, x -> if (isValidSpan(a,x)) x else -9 }
}

fun areValidArrangements(adapters: List<Int>) {
    val size = adapters.size
}

fun isValidArrangement(adaptersSorted: List<Int>, hiddenAdapters: Map<Int,Boolean>): Boolean {
    return 0 < adaptersSorted.reduce { a, x ->
        if (isHidden(x, hiddenAdapters)) a else if (isValidSpan(a, x)) x else -9
    }
}

private fun isValidSpan(x1: Int, x2: Int) = x1 < x2 && x2 <= x1 + 3
fun isHidden(x:Int, hiddenAdapters: Map<Int,Boolean>) = hiddenAdapters.getOrDefault(x, false)

/**
 * Find a chain that uses all of your adapters to connect the charging outlet to your device's built-in adapter
 * and count the joltage differences between the charging outlet, the adapters, and your device.
 */
fun adapterJoltageDiffs(adapters: List<Int>): Map<Int, Int> {
    val adaptersSorted = adapters.sortedBy { it }
    val aHigh = adaptersSorted.plus(adaptersSorted.last() + 3)
    val aLow = listOf(0).plus(adaptersSorted)
    val aDiffs = aLow.zip(aHigh)
        .map { it.second - it.first }
        .sortedBy { it }
        .groupingBy { it }
        .fold(0) { acc, _ -> acc.inc() }

    println("Diffs: $aDiffs")
    return aDiffs
}

/**
 * Part1 question: What is the number of 1-jolt differences multiplied by the number of 3-jolt differences?
 */
fun answerPart1(xDiffs: Map<Int, Int>): Int {
//    val answer = xDiffs.values.reduce{a,b -> a*b} // There are only 1 and 3 diffs, so this also works
    val answer = xDiffs.entries.filter { e -> e.key == 1 || e.key == 3 }.fold(1) { acc, e -> acc * e.value }

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

operator fun BigInteger.rangeTo(other: BigInteger) =
    BigIntegerRange(this, other)

class BigIntegerRange(
    override val start: BigInteger,
    override val endInclusive: BigInteger
) : ClosedRange<BigInteger>, Iterable<BigInteger> {
    override operator fun iterator(): Iterator<BigInteger> =
        BigIntegerRangeIterator(this)
}

class BigIntegerRangeIterator(
    private val range: ClosedRange<BigInteger>
) : Iterator<BigInteger> {
    private var current = range.start

    override fun hasNext(): Boolean =
        current <= range.endInclusive

    override fun next(): BigInteger {
        if (!hasNext()) {
            throw NoSuchElementException()
        }
        return current++
    }
}