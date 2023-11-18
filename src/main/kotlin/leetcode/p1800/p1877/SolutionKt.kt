package leetcode.p1800.p1877

class SolutionKt {
    fun minPairSum(nums: IntArray): Int =
        nums.sorted().run { zip(asReversed()).maxOf { it.first + it.second } }

    fun minPairSum1(nums: IntArray): Int = nums.sort().let {
        IntArray(nums.size / 2) {
            nums[it] + nums[nums.size - 1 - it]
        }.max()
    }
}