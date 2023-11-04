package leetcode.p1500.p1503

class SolutionKt {
    fun getLastMoment(n: Int, left: IntArray, right: IntArray): Int {
        return maxOf((left.maxOrNull() ?: 0), n - (right.minOrNull() ?: n))
    }
}