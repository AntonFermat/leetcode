package leetcode.p1100.p1143

class SolutionKt {
    fun longestCommonSubsequence(text1: String, text2: String): Int {
        val n1 = text1.length
        val n2 = text2.length
        if (n1 < n2) return longestCommonSubsequence(text2, text1)
        var dp = IntArray(n2 + 1)
        for (i in 0 ..< n1) {
            val ndp = IntArray(n2 + 1)
            for (j in 0 ..< n2) {
                if (text1[i] == text2[j]) ndp[j + 1] = 1 + dp[j] else ndp[j + 1] = Math.max(ndp[j], dp[j + 1])
            }
            dp = ndp
        }
        return dp[n2]
    }
}