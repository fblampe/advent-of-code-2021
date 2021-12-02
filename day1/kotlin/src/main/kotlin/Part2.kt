import java.io.File

fun main() {
    val numbers = File("input").readText().split("\n").map { it.toInt() }

    val result = countIncreasesWithSlidingWindow(numbers)

    println(result)
}

fun countIncreasesWithSlidingWindow(numbers: List<Int>) =
    countIncreases(numbers.windowed(3, 1).map { it.sum() })