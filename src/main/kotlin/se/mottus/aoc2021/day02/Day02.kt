package se.mottus.aoc2021.day02

/**
 * https://adventofcode.com/2021/day/2
 */

fun part1(input: List<String>): Int =
    moves2Position(input).let{it.horizontalPosition * it.depth}

fun part2(input: List<String>): Int =
    actions2PositionAndAim(input).let{it.horizontalPosition * it.depth}

/** forward X increases the horizontal position by X units.
    down X increases the depth by X units.
    up X decreases the depth by X units  */
fun moves2Position(moves: List<String>): Position {
    return moves.fold(Position(0,0)) {acc, move -> acc + move2Position(move)}
}

/** forward X increases the horizontal position by X units.
    down X increases the depth by X units.
    up X decreases the depth by X units  */
fun actions2PositionAndAim(moves: List<String>): PositionAndAim {
    return moves.fold(PositionAndAim(0,0, 0)) {acc, move -> acc.execute(move)}
}

fun move2Position(move: String): Position {
    val direction = move.split(" ")[0]
    val length = move.split(" ")[1].toInt()
    return when (direction) {
        "forward" -> Position(length,0)
        "down" -> Position(0, length)
        "up" -> Position(0, -length)
        else -> throw IllegalArgumentException("Illegal move $move")
    }
}

data class Position(val horizontalPosition: Int, val depth: Int) {
    operator fun plus(position: Position): Position =
        Position(horizontalPosition + position.horizontalPosition, depth + position.depth)
}

/** down X increases your aim by X units.
    up X decreases your aim by X units.
    forward X does two things:
    It increases your horizontal position by X units.
    It increases your depth by your aim multiplied by X. */
data class PositionAndAim(val horizontalPosition: Int, val depth: Int, val aim: Int) {
    fun forward(x: Int): PositionAndAim = PositionAndAim(horizontalPosition + x, depth + aim * x, aim)
    fun up(x: Int): PositionAndAim = PositionAndAim(horizontalPosition, depth, aim - x)
    fun down(x: Int): PositionAndAim = PositionAndAim(horizontalPosition, depth, aim + x)
    fun execute(action: String): PositionAndAim {
        val actionType = action.split(" ")[0]
        val x = action.split(" ")[1].toInt()
        return when (actionType) {
            "forward" -> forward(x)
            "down" -> down(x)
            "up" -> up(x)
            else -> throw IllegalArgumentException("Illegal action $action")
        }

    }
}
