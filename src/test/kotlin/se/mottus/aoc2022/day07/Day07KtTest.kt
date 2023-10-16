package se.mottus.aoc2022.day07

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Day07KtTest {
    private val testInput = """
        $ cd /
        $ ls
        dir a
        14848514 b.txt
        8504156 c.dat
        dir d
        $ cd a
        $ ls
        dir e
        29116 f
        2557 g
        62596 h.lst
        $ cd e
        $ ls
        584 i
        $ cd ..
        $ cd ..
        $ cd d
        $ ls
        4060174 j
        8033020 d.log
        5626152 d.ext
        7214296 k
    """.trimIndent().lines()

    @Test
    fun parseOneDirTest() {
        val lsOutput = "$ ls\ndir a\n14848514 b.txt\n8504156 c.dat\ndir d".lines().drop(1)
        val dir = parseDir("/", lsOutput)

        assertEquals(setOf("a", "d"), dir.dirs.keys)

        assertEquals(setOf("b.txt", "c.dat"), dir.files.keys)
        assertEquals(14848514, dir.files.get("b.txt"))
        assertEquals(8504156, dir.files.get("c.dat"))
        assertEquals(14848514 + 8504156, dir.files.values.sum())

        dir.dirs.put("a", Dir(files = mapOf("fil" to 99)))
        assertEquals(99, dir.dirs.get("a")?.files?.get("fil"))
    }

}
