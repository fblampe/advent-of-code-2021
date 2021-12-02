import java.io.File

fun main() {
    val numbers = File("input").readText().split("\n").map { it.toInt() }

    val result = countIncreases(numbers)

    println(result)
}

fun countIncreases(numbers: List<Int>) =
    numbers.zipWithNext().filter { it.second > it.first }.count()