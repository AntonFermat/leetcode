package leetcode.p1700.p1759

class SolutionKt {
    fun countHomogenous(s: String): Int {
        var res = 1
        var cur = 1
        for (i in 1 until s.length) {
            if (s[i] == s[i - 1]) cur++
            else cur = 1
            res = (res + cur) % 1_000_000_007
        }
        return res
    }
}