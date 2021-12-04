import java.io.File

fun main() {
    val bitStrings = File("input").readText().split("\n")

    val listsOfBitsAsInts = bitStrings.map { bitString -> bitString.toCharArray().map { it.toString().toInt() } }

    val sums = listsOfBitsAsInts.sumVertically()

    val gamma = sums.map { if (it > 500) 1 else 0 }.joinToString("").toInt(2)
    val epsilon = sums.map { if (it < 500) 1 else 0 }.joinToString("").toInt(2)

    println("gamma: $gamma")
    println("epsilon: $epsilon")
    println("answer: ${gamma * epsilon}")
}

fun List<List<Int>>.sumVertically(): List<Int> = fold(arrayOfNulls<Int>(12).map { 0 }) { acc: List<Int>, bits ->
    acc.zip(bits).map { (x, y) -> x + y }
}