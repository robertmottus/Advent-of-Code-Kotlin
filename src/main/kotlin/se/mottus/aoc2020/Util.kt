package se.mottus.aoc2020

import java.io.File

fun readResource(path: String, fileName: String): List<String> =
    readResource(path.replace('.', '/') + "/" + fileName)

fun readResource(filePath: String): List<String> =
    File(ClassLoader.getSystemResource(filePath).file).readText().lines()
