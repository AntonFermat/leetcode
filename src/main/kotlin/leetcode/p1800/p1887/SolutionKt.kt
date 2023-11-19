package leetcode.p1800.p1887

class SolutionKt {
    fun reductionOperations(nums: IntArray): Int =
        nums.sortedDescending().zipWithNext().withIndex()
            .fold(0) { acc, it -> acc + if (it.value.first != it.value.second) it.index + 1 else 0 }
}