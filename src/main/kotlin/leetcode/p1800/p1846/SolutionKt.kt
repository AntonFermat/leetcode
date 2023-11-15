package leetcode.p1800.p1846

class SolutionKt {
    fun maximumElementAfterDecrementingAndRearranging(arr: IntArray): Int {
        var res = 0
        arr.sorted().forEach { if (it != res) res++ }
        return res
    }
}