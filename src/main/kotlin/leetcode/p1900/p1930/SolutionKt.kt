package leetcode.p1900.p1930

class SolutionKt {
    fun countPalindromicSubsequence(s: String): Int {
        var res = 0
        for (c in 'a'..'z') {
            val first = s.indexOf(c) + 1
            val last = s.lastIndexOf(c)
            res += s.withIndex().filter { it.index in first until last }.map { it.value }.toSet().size
        }
        return res
    }
}