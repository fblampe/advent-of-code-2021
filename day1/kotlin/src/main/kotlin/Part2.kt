import java.io.File

fun main() {
    val numbers = File("input").readText().split("\n").map { it.toInt() }

    val result = countIncreasesWithSlidingWindow(numbers)

    println(result)
}

fun countIncreasesWithSlidingWindow(numbers: List<Int>): Int {
    val slidingWindowOf3Sum = numbers.zipWithNext().dropLast(1).zip(numbers.drop(2)) { (first, second), third ->
        first + second + third
    }

    return countIncreases(slidingWindowOf3Sum)
}