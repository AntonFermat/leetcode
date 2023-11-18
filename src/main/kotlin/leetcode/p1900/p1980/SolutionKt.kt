package leetcode.p1900.p1980

class SolutionKt {
    fun findDifferentBinaryString(nums: Array<String>): String = nums.withIndex().map { if(it.value[it.index] == '0') 1 else 0 }.joinToString("")
}