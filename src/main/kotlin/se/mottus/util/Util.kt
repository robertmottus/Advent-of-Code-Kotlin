package se.mottus.util

import java.io.File

fun readResourceAsLines(path: String, fileName: String): List<String> =
    readResourceAsLines(path.replace('.', '/') + "/" + fileName)

fun readResourceAsLines(filePath: String): List<String> =
    File(ClassLoader.getSystemResource(filePath).file).readText().lines()

fun readResource(path: String, fileName: String): String {
    val filePath = path.replace('.', '/') + "/" + fileName
    return File(ClassLoader.getSystemResource(filePath).file).readText()
}
