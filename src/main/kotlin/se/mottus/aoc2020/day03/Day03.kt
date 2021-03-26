package se.mottus.aoc2020.day03

data class Point(val x:Int, val y:Int)
data class MapOfTrees(val width:Int, val height:Int, val treePositions:Map<Point, Boolean>)

fun part1(input: List<String>): Int {
    return countTrees(inputToMapOfTreePositions(input), input[0].length, input.size)
}

fun part2(input: List<String>): Int {
    return countTreesPart2(inputToMapOfTreePositions(input), input[0].length, input.size)
}

fun isTree(point: Point, grid: Map<Point, Boolean>, width:Int): Boolean {
    return grid.getOrDefault(point.copy(x = point.x % width), false)
}

fun inputToMapOfTreePositions(inputRows: List<String>): Map<Point, Boolean> {
    return inputRows.flatMapIndexed{y, row -> row
        .foldIndexed(emptyList<Point>()){x, a, c -> if('#' == c) a.plus(Point(x,y)) else a}}
        .map{it to true}.toMap()
}

fun countTreesPart2(mapOfTrees: MapOfTrees): Int {
    return countTreesPart2(mapOfTrees.treePositions, mapOfTrees.width, mapOfTrees.height)
}

fun countTreesPart2(mapOfTrees: Map<Point, Boolean>, width: Int, height: Int): Int {
    fun countTrees(slope:Point) = countTrees(mapOfTrees, width, height, slope)

    var countProduct = 1
    countProduct *= countTrees(Point(1,1))
    countProduct *= countTrees(Point(3,1))
    countProduct *= countTrees(Point(5,1))
    countProduct *= countTrees(Point(7,1))
    countProduct *= countTrees(Point(1,2))

    return countProduct
}

fun countTreesPart2(input:List<String>): Int {
    val mapOfTrees = inputToMapOfTrees(input)
    fun countTrees(slope:Point) = countTrees(mapOfTrees, slope)

    var countProduct = 1
    countProduct *= countTrees(Point(1,1))
    countProduct *= countTrees(Point(3,1))
    countProduct *= countTrees(Point(5,1))
    countProduct *= countTrees(Point(7,1))
    countProduct *= countTrees(Point(1,2))

    return countProduct
}

fun inputToMapOfTrees(input: List<String>):MapOfTrees = MapOfTrees(input[0].length, input.size, inputToMapOfTreePositions(input))

fun countTrees(input: List<String>, slope: Point = Point(3,1)) =
    countTrees(inputToMapOfTrees(input), slope)

fun countTrees(mapOfTrees: MapOfTrees, slope: Point = Point(3,1)): Int =
    countTrees(mapOfTrees.treePositions, mapOfTrees.width, mapOfTrees.height, slope)

fun countTrees(mapOfTrees: Map<Point, Boolean>, width: Int, height: Int, slope: Point = Point(3,1)): Int {
    return (0 until height)
        .map{step -> step * slope}
        .map{p -> isTree(p,mapOfTrees, width)}
        .count{p -> p}
}

private operator fun Int.times(slope: Point): Point {
    return Point(this * slope.x, this * slope.y)
}

