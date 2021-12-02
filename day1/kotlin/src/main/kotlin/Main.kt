import java.io.File

fun main() {
    val numbers = File("input").readText().split("\n").map { it.toInt() }

    var previous: Int? = null
    var increaseCount = 0
    for (number: Int in numbers) {
        if (previous != null && number > previous) increaseCount++
        previous = number
    }

    println(increaseCount)
}