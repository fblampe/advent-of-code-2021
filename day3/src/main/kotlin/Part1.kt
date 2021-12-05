import java.io.File

fun main() {
    val bitStrings = File("input").readText().split("\n")

    val listsOfBitsAsInts = bitStrings.toListOfIntBits()

    val gamma = listsOfBitsAsInts.mostCommonBitValues().toDecimalInt()
    val epsilon = listsOfBitsAsInts.leastCommonBitValues().toDecimalInt()

    println("gamma: $gamma")
    println("epsilon: $epsilon")
    println("answer: ${gamma * epsilon}")
}

fun List<String>.toListOfIntBits() = map { bitString -> bitString.toCharArray().map { it.toString().toInt() } }

fun List<List<Int>>.mostCommonBitValues() =
    sumVertically().map { if (it >= size / 2.0) 1 else 0 }

fun List<List<Int>>.leastCommonBitValues() =
    sumVertically().map { if (it < size / 2.0) 1 else 0 }

fun List<List<Int>>.sumVertically(): List<Int> =
    fold(arrayOfNulls<Int>(this.first().size).map { 0 }) { acc: List<Int>, bits ->
        acc.zip(bits).map { (x, y) -> x + y }
    }

fun List<Int>.toDecimalInt() = joinToString("").toInt(2)
