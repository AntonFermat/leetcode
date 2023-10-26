package leetcode.p0800.p0823

import java.util.*

class SolutionKt {
    fun numFactoredBinaryTrees(arr: IntArray): Int {
        val mod = 1_000_000_007
        Arrays.sort(arr)
        val map = HashMap<Int, Int>()
        for (num in arr) {
            var count = 1
            val prev = map.keys
            for (num1 in prev) {
                if (num % num1 == 0) {
                    val num2 = num / num1
                    if (prev.contains(num2)) {
                        count = (count + ((1L * map[num1]!! * map[num2]!!) % mod).toInt()) % mod
                    }
                }
            }
            map[num] = count
        }
        var res = 0
        for (count in map.values) res = (res + count) % mod
        return res
    }
}