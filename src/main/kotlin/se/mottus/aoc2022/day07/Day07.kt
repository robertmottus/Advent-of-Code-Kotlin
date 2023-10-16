package se.mottus.aoc2022.day07

/**
 * https://adventofcode.com/2022/day/7
 */
fun part1(input: List<String>): String {
    return "TODO"
}
data class Dir(
    val parent: Dir? = null, // null indicates top dir "/"
    val dirs: MutableMap<String, Dir> = mutableMapOf(),
    val files: Map<String, Int> = emptyMap(),
)

fun parseDir(name: String, lsOutput: List<String>): Dir {
    val files = lsOutput.filter { t -> !t.startsWith("dir") }
        .map{text -> text.split(" ")}
        .map{it[1] to it[0].toInt()}.toMap()
    val folders = lsOutput.filter { t -> t.startsWith("dir") }
        .map{text -> text.split(" ")}
        .map{it[1] to Dir()}.toMap().toMutableMap()
    return Dir(files = files, dirs = folders)
}

fun parseFolderOld(name: String, lsOutput: List<String>): FolderOld {
    val files = lsOutput.filter { t -> !t.startsWith("dir") }
        .map{text -> text.split(" ")}
        .map{t ->  FileOld(t[1], t[0].toInt()) }
    val folders = lsOutput.filter { t -> t.startsWith("dir") }
        .map{text -> text.split(" ")}
        .map{t ->  FolderOld(t[1]) }
    return FolderOld(name = name, files = files, folders = folders)
}

data class FolderOld(
    val name: String,
    val folders: List<FolderOld> = emptyList(),
    val files: List<FileOld> = emptyList(),
)

data class FileOld(
    val name: String,
    val fileSize: Int = 0
)

