package leetcode.p0600.p0645

class SolutionKt {
    fun findErrorNums(nums: IntArray): IntArray {
        val len = nums.size
        val count = IntArray(len)
        val res = IntArray(2)
        for (num in nums) count[num - 1]++
        for (i in 0 ..< len) {
            if (count[i] == 2) res[0] = i + 1 else if (count[i] == 0) res[1] = i + 1
        }
        return res
    }
}