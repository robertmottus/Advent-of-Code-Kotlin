package se.mottus.aoc2020.day05

import java.lang.Math.pow

fun part1(input: List<String>): Int = input.map {str2Seat(it)}.map {seatId(it)}.maxOrNull()!!

fun part2(input: List<String>): Int {
    return 0
}

fun seatId(seat: Pair<Int, Int>): Int = seat.first * 8 + seat.second

fun str2Seat(seatString: String): Pair<Int, Int> {
    return Pair(position(seatString.substring(0, 7), "FB"), position(seatString.substring(7, 10), "LR"))
}

fun position(posString: String, chars: String): Int =
    posString
        .reversed()
        .foldIndexed(0) { i, a, c ->
            val positionFactor = pow(2.0, i.toDouble()).toInt()
            val lowHighFactor = chars.indexOf(c)
            a + positionFactor * lowHighFactor
        }.toInt()

