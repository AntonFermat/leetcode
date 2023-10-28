package leetcode.p0000.p0005

class SolutionKt {
    fun longestPalindrome(s: String): String {
        var l = 0
        var r = 0
        for (i in s.indices) {
            val len = maxOf(helper(s, i, i), helper(s, i, i + 1))
            if (len > r - l) {
                l = i - (len - 1) / 2
                r = i + len / 2
            }
        }
        return s.substring(l, r + 1)
    }

    fun helper(s: String, left: Int, right: Int): Int {
        var l = left
        var r = right
        while (l >= 0 && r < s.length && s[l] == s[r]) {
            l--
            r++
        }
        return r - l - 1
    }
}