package se.mottus.aoc2023.day02

/**
 * https://adventofcode.com/2023/day/2
 */
// which games would have been possible if the bag contained only 12 red cubes, 13 green cubes, and 14 blue cubes?
val availableCubes = mapOf(Pair("red", 12), Pair("green", 13), Pair("blue", 14))

fun part1(gameStrings: List<String>) =
    // "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green"
    gameStrings
        .filter {
            val (label, game) = it.split(":")
            isValidGame(game.trim())
        }
        .map {
            val (label, game) = it.split(":")
            val gameNr = label.drop(5).trim().toInt()
            gameNr
        }
        .sum()

//fun part2(input: List<String>): Int = 0


fun isValidGame(game: String): Boolean {
    // Example game (consists of semicolon separated sets): "3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green"
    game.split(";").forEach { setString ->
        if (!isValidSet(toSetMap(setString))) return false
    }
    return true
}

fun isValidSet(cubeMap: Map<String, Int>): Boolean {
    for (cubeColorCount in cubeMap)
        if (cubeColorCount.value > availableCubes[cubeColorCount.key]!!)
            return false
    return true
}

fun toSetMap(setString: String): Map<String, Int> {
    val setMap = mutableMapOf<String, Int>()
    setString.split(",").forEach { cubeString ->
        val (count, color) = cubeString.trim().split(" ")
        setMap[color] = count.toInt()
    }
    return setMap
}
