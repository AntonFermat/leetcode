package leetcode.p1900.p1913

class SolutionKt {
    fun maxProductDifference(nums: IntArray): Int = nums.sorted().run { get(nums.size - 1) * get(nums.size - 2) - get(0) * get(1) }
}