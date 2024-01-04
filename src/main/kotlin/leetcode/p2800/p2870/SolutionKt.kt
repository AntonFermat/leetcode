package leetcode.p2800.p2870

class SolutionKt {
    fun minOperations(nums: IntArray): Int =
        nums.toList().groupingBy { it }
            .eachCount().values.fold(0) { acc, it ->
                if (acc == -1 || it == 1) -1 else acc + Math.ceil(it.toDouble() / 3).toInt()
            }
}