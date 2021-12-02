import java.io.File

fun main() {
    var horizontal = 0
    var vertical = 0
    var aim = 0
    val moves = File("inputSofia").readText().split("\n")

    moves.forEach {
        val direction = it.substringBefore(" ")
        val amount = it.substringAfter(" ").toInt()
        when (direction) {
            "forward" -> {
                horizontal += amount
                vertical += aim * amount
            }
            "up" -> aim -= amount
            "down" -> aim += amount
        }
    }

    println("X: $horizontal, Y: $vertical")
    println("result: ${horizontal * vertical}")
}