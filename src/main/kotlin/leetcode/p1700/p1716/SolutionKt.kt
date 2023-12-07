package leetcode.p1700.p1716

class SolutionKt {
    fun totalMoney(n: Int): Int = (0..<n).fold(0) { acc, it -> acc + it / 7 + it % 7 + 1 }
}