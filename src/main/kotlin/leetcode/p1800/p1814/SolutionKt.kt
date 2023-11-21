package leetcode.p1800.p1814

class SolutionKt {
    fun countNicePairs(nums: IntArray): Int =
        nums.map { it - it.toString().reversed().toInt() }.groupingBy { it }.eachCount().values
            .fold(0L) { acc, it -> (acc + (-1L + it) * it / 2) % 1_000_000_007 }.toInt()
}