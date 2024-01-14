package leetcode.p1300.p1347

import kotlin.math.abs

class SolutionKt {
    fun minSteps(s: String, t: String): Int =
        ('a'..'z').sumOf { abs(s.count { c -> it == c } - t.count { c -> it == c }) } / 2
}