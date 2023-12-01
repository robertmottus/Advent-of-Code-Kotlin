package se.mottus.aoc2023.day01

/**
 * https://adventofcode.com/2023/day/1
 */
fun part1(input: List<String>): Int = sumNumbers(input) { x -> toNumber1(x) }
fun part2(input: List<String>): Int = sumNumbers(input) { x -> toNumber2(x) }

// First and last digit, as number
fun toNumber1(string: String) =
    string.filter { c -> c.isDigit() }
        .let{
            val firstDigit = it.first() - '0'
            val lastDigit = it.last() - '0'
            firstDigit * 10 + lastDigit
        }

val stringDigits = mapOf(
    Pair("one", 1),
    Pair("two", 2),
    Pair("three", 3),
    Pair("four", 4),
    Pair("five", 5),
    Pair("six", 6),
    Pair("seven", 7),
    Pair("eight", 8),
    Pair("nine", 9)
)

fun toNumber2(string: String): Int {
    var firstDigit = 0
    for (index in string.indices) {
        val x = searchDigit(string.drop(index))
        if (x != null) {
            firstDigit = x
            break
        }
    }

    var lastDigit = 0
    for (index in string.indices.reversed()) {
        val x = searchDigit(string.drop(index))
        if (x != null) {
            lastDigit = x
            break
        }
    }
    return 10 * firstDigit + lastDigit
}

private fun searchDigit(str: String): Int? {
    if (str.first().isDigit()) {
        return str.first() - '0'
    } else {
        val x = stringDigits.filter { str.startsWith(it.key) }
        if (x.size == 1) {
            return x.values.first()
        }
    }
    return null
}

fun sumNumbers(doc: List<String>, sumNumbers: (String) -> Int) =
    doc.map {
        l -> sumNumbers(l)
    }
    .sum()
