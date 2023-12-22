package leetcode.p1400.p1422

class SolutionKt {
    fun maxScore(s: String): Int =
        s.dropLast(1).scan(s.sumOf { it - '0' }) { acc, it -> acc + 1 - 2 * (it - '0') }.drop(1).max()
}