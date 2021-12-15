import java.io.File

const val SEPARATOR = " -> "

data class Point(val x: Int, val y: Int)
typealias Line = Pair<Point, Point>

fun main() {
    val linesOfText = File("input").readText().split("\n")
    val linesOfVents = linesOfText.map { lineOfText ->
        val points = lineOfText.split(SEPARATOR).map(String::toPoint)
        val vents: Line = points.toLine()
        vents
    }

    val horizontalAndVerticalLines = linesOfVents.filter { it.first.x == it.second.x || it.first.y == it.second.y }
    val allPointsWithVents = horizontalAndVerticalLines.flatMap { it.containedPoints() }
    val overlapPoints = allPointsWithVents.onlyDuplicates()
    println(overlapPoints.size)
}

private fun Line.containedPoints(): Collection<Point> {
    val xs = first.x toward second.x
    val ys = first.y toward second.y
    return (xs.map { Point(it, ys.first) } + ys.map { Point(xs.first, it) }).toSet()
}

private infix fun Int.toward(to: Int): IntProgression {
    val step = if (this > to) -1 else 1
    return IntProgression.fromClosedRange(this, to, step)
}

private fun String.toPoint(): Point {
    val coordinates = split(",").map { it.toInt() }
    return Point(coordinates[0], coordinates[1])
}

private fun List<Point>.toLine(): Line = zipWithNext().single()

private fun <T> Collection<T>.onlyDuplicates() = groupingBy { it }.eachCount().filter { it.value > 1 }.map { it.key }
