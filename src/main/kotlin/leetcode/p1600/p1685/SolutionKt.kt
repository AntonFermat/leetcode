package leetcode.p1600.p1685

class SolutionKt {
    fun getSumAbsoluteDifferences(nums: IntArray): IntArray {
        val sum = nums.sum()
        val res = IntArray(nums.size)
        var prev = 0
        for ((i, num) in nums.withIndex()) {
            res[i] = sum - prev * 2 + num * (i * 2 - nums.size)
            prev += num
        }
        return res
    }
}