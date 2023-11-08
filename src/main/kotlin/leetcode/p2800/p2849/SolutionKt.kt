package leetcode.p2800.p2849

import kotlin.math.abs

class SolutionKt {
    fun isReachableAtTime(sx: Int, sy: Int, fx: Int, fy: Int, t: Int): Boolean =
        if (t == 0) sx == fx && sy == fy
        else if (sx == fx && sy == fy && t == 1) false
        else maxOf(abs(sx - fx), abs(sy - fy)) <= t
}