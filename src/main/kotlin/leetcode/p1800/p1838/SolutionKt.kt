package leetcode.p1800.p1838

class SolutionKt {
    fun maxFrequency(nums: IntArray, k: Int): Int = nums.size - nums.run {
        nums.sort()
        withIndex().fold(mutableListOf(0, 0)) { acc, it ->
            acc[1] += it.value
            if ((it.index - acc[0] + 1) * it.value - acc[1] > k) acc[1] -= nums[acc[0]++]
            acc
        }[0]
    }
}