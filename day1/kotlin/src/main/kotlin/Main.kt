import java.io.File

fun main() {
    val numbers = File("input").readText().split("\n").map { it.toInt() }

    val result = numbers.zipWithNext().filter { it.second > it.first }.count()

    println(result)
}