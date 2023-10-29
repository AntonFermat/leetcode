package leetcode.p0400.p0458

import kotlin.math.*


class SolutionKt {
    fun poorPigs(buckets: Int, minutesToDie: Int, minutesToTest: Int): Int {
        val states = minutesToTest / minutesToDie + 1
        val res = ceil(log(buckets.toDouble(), states.toDouble())).toInt()
        return if (Math.pow(states.toDouble(), (res - 1).toDouble()) == buckets.toDouble()) res - 1 else res
    }
}