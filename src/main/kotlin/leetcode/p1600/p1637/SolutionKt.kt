package leetcode.p1600.p1637

class SolutionKt {
    fun maxWidthOfVerticalArea(points: Array<IntArray>): Int =
        points.map { it[0] }.toSortedSet().run { if (size == 1) 0 else zipWithNext().maxOf { it.second - it.first } }
}