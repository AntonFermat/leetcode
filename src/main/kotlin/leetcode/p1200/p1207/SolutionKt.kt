package leetcode.p1200.p1207

class SolutionKt {
    fun uniqueOccurrences(arr: IntArray): Boolean =
        arr.toList().groupingBy { it }.eachCount().values.let { it.size == it.toSet().size }
}