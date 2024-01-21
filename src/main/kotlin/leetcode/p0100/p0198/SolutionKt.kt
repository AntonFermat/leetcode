package leetcode.p0100.p0198

class SolutionKt {
    fun rob(nums: IntArray): Int =
        nums.fold(0 to 0) { acc, it -> acc.second to maxOf(acc.first + it, acc.second) }.second
}