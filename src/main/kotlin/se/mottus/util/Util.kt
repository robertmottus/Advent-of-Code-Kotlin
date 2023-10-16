package se.mottus.util

import java.io.File

fun readResourceAsLines(path: String, fileName: String): List<String> =
    readResource(filePath(path, fileName)).lines()

fun readResourceAsLines(filePath: String): List<String> =
    readResource(filePath).lines()

fun readResource(path: String, fileName: String): String =
    readResource(filePath(path, fileName))

fun readResource(filePath: String): String =
    File(ClassLoader.getSystemResource(filePath).file).readText()

private fun filePath(path: String, fileName: String) = path.replace('.', '/') + "/" + fileName
