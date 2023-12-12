package leetcode.p1400.p1464

class SolutionKt {
    fun maxProduct(nums: IntArray): Int =
        nums.fold(0 to 0) { acc, it -> if (it > acc.first) it to acc.first else acc.first to maxOf(it, acc.second) }.run { (first - 1) * (second - 1) }
}