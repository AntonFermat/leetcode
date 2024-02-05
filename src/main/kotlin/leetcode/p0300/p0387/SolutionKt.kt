package leetcode.p0300.p0387

class SolutionKt {
    fun firstUniqChar(s: String): Int = s.indexOfFirst { s.indexOf(it) == s.lastIndexOf(it) }
}