import java.io.File

fun main() {
    var horizontal = 0
    var vertical = 0
    val moves = File("input").readText().split("\n")

    moves.forEach {
        val direction = it.substringBefore(" ")
        val amount = it.substringAfter(" ").toInt()
        when (direction) {
            "forward" -> horizontal += amount
            "up" -> vertical -= amount
            "down" -> vertical += amount
        }
    }

    println("X: $horizontal, Y: $vertical")
    println("result: ${horizontal * vertical}")
}