package leetcode.p1900.p1903

class SolutionKt {
    fun largestOddNumber(num: String): String = num.trimEnd { "02468".contains(it) }
}