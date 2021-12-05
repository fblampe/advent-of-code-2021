import java.io.File
import kotlin.reflect.KFunction1

fun main() {
    val bitStrings = File("input").readText().split("\n")

    val listsOfBitsAsInts = bitStrings.toListOfIntBits()

    val o2Rating = findRating(listsOfBitsAsInts, List<List<Int>>::mostCommonBitValues)
    val co2Rating = findRating(listsOfBitsAsInts, List<List<Int>>::leastCommonBitValues)

    println("O2 rating: $o2Rating")
    println("CO2 rating: $co2Rating")
    println("result: ${o2Rating * co2Rating}")
}

private fun findRating(
    listsOfBitsAsInts: List<List<Int>>,
    createComparison: KFunction1<List<List<Int>>, List<Int>>
): Int {
    var candidates = listsOfBitsAsInts
    var bitIndex = 0
    while (candidates.size > 1) {
        val mostOrLeastCommonBitValues = createComparison(candidates)
        candidates = candidates.filter { it[bitIndex] == mostOrLeastCommonBitValues[bitIndex] }
        bitIndex++
    }
    return candidates.first().toDecimalInt()
}