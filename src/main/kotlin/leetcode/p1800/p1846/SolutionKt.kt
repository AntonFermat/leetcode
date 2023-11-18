package leetcode.p1800.p1846

class SolutionKt {
    fun maximumElementAfterDecrementingAndRearranging(arr: IntArray): Int =
        arr.sorted().fold(0) { acc, it -> acc + if (it != acc) 1 else 0 }
}