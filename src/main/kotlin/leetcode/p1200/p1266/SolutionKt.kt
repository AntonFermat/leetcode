package leetcode.p1200.p1266

import kotlin.math.*

class SolutionKt {
    fun minTimeToVisitAllPoints(points: Array<IntArray>): Int = points.asList().zipWithNext()
        .fold(0) { acc, it -> acc + max(abs(it.first[0] - it.second[0]), abs(it.first[1] - it.second[1])) }
}