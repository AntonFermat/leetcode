package leetcode.p1400.p1425

import java.util.*

class SolutionKt {
    fun constrainedSubsetSum(nums: IntArray, k: Int): Int {
        var res = Int.MIN_VALUE
        val len = nums.size
        val dp = IntArray(len)
        val map = TreeMap<Int, Int>()
        for (i in 0 until len) {
            val cur = Math.max(nums[i], nums[i] + if (map.isEmpty()) 0 else map.lastKey())
            map[cur] = map.getOrDefault(cur, 0) + 1
            dp[i] = cur
            res = Math.max(res, cur)

            if (i >= k) {
                val rem = dp[i - k]
                val count = map[rem]!!
                if (count == 1) map.remove(rem) else map[rem] = count - 1
            }
        }
        return res
    }
}