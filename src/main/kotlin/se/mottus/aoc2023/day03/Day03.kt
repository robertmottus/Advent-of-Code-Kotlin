package se.mottus.aoc2023.day03

import kotlin.math.max
import kotlin.math.min

/**
 * https://adventofcode.com/2023/day/3
 */

fun part1(gameStrings: List<String>): Int {
    val symbols = parseSymbols(gameStrings)
    val partNumbers = parsePartNumbers(gameStrings, symbols)
    return partNumbers.sum()
}

//fun part2(gameStrings: List<String>) = 0

data class Coordinate(val x: Int, val y:Int)

fun parseSymbols(schema: List<String>) : Set<Coordinate> {
    fun isSymbol(c: Char) = c != '.' && !c.isDigit()
    val symbolCoordinates = mutableSetOf<Coordinate>()
    for(y in schema.indices) {
        for(x in schema.indices) {
            if(isSymbol(schema[y][x])) symbolCoordinates.add(Coordinate(x,y))
        }
    }
    return symbolCoordinates
}

fun parsePartNumbers(schema: List<String>, symbols: Set<Coordinate>) : List<Int> {
    val partNumbers = mutableListOf<Int>()
    val regexNumber = """\d+""".toRegex()
    for(y in schema.indices) {
        var parsingNumber = false
        val row = schema[y]
        for(x in schema.indices) {
            if(row[x].isDigit()) {
                if(parsingNumber)
                    continue // skip rest of digits in the number
                parsingNumber = true
                val number = regexNumber.find(row.substring(x))!!.value.toInt()
                if(isPartNumber(Coordinate(x,y), number, maxCoordinate(schema), symbols))
                    partNumbers.add(number)
            } else {
                parsingNumber = false
                continue
            }
        }
    }
    return partNumbers
}

fun isPartNumber(numPos: Coordinate, number: Int, maxCoordinate: Coordinate, symbols: Set<Coordinate>): Boolean {
    // If the number has a symbol as a neighbour in the schema, the number is a part number
    val rowAbove = max(0, numPos.y - 1)
    val rowBelow = min(maxCoordinate.y, numPos.y + 1)
    val posBefore = max(0,numPos.x -1)
    val posAfter = min(maxCoordinate.x, numPos.x + number.toString().length)
    for (y in rowAbove .. rowBelow)
        for(x in posBefore .. posAfter) {
            if(symbols.contains(Coordinate(x,y))) return true
        }
    return false
}

fun maxCoordinate(schema: List<String>) = Coordinate(schema[0].length - 1, schema.size - 1)
