package se.mottus.aoc2020.day05

import java.lang.Math.max
import java.lang.Math.pow

fun part1(input: List<String>): Int = seatIds(input).maxOrNull()!!

fun part2(input: List<String>): Int =
    seatIds(input).sorted().zipWithNext().fold(0) { acc, seatPair -> if(seatPair.second - seatPair.first == 2) seatPair.first+1 else acc}

private fun seatIds(input: List<String>):List<Int> = input.map { str2Seat(it) }.map { seatId(it) }

fun seatId(seat: Pair<Int, Int>): Int = seat.first * 8 + seat.second

fun str2Seat(seatString: String): Pair<Int, Int> {
    return Pair(position(seatString.substring(0, 7), "FB"), position(seatString.substring(7, 10), "LR"))
}

fun position(posString: String, chars: String): Int =
    posString.replace(chars[0], '0').replace(chars[1], '1').toInt(2)

fun positionOld(posString: String, chars: String): Int =
    posString
        .reversed()
        .foldIndexed(0) { i, a, c ->
            val positionFactor = pow(2.0, i.toDouble()).toInt()
            val lowHighFactor = chars.indexOf(c)
            a + positionFactor * lowHighFactor
        }.toInt()

fun part1_optimized(input: List<String>): Int {
    input.map { str2Seat(it) }.fold(0){acc, seat ->
        val seatId = seatId(seat)
        return max(acc, seatId)
    }
    return seatIds(input).maxOrNull()!!
}
