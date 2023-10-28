package leetcode.p1200.p1220

class SolutionKt {
    fun countVowelPermutation(n: Int): Int {
        val mod = 1_000_000_007
        val dp = Array(n + 1) { LongArray(5) }
        for (i in 0..4) dp[1][i] = 1
        for (i in 1 until n) {
            dp[i + 1][0] = (dp[i][4] + dp[i][1] + dp[i][2]) % mod
            dp[i + 1][1] = (dp[i][0] + dp[i][2]) % mod
            dp[i + 1][2] = (dp[i][3] + dp[i][1]) % mod
            dp[i + 1][3] = dp[i][2] % mod
            dp[i + 1][4] = (dp[i][2] + dp[i][3]) % mod
        }
        var res: Long = 0
        for (i in 0..4) res = (res + dp[n][i]) % mod
        return res.toInt()
    }
}