package leetcode.p1200.p1287

class SolutionKt {
    fun findSpecialInteger(arr: IntArray): Int = arr.first { a -> arr.count { it == a } > arr.size / 4 }
}