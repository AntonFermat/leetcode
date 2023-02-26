fun minDistance(word1: String, word2: String): Int {
    val len1 = word1.length
    val len2 = word2.length
    val dp = Array(len1 + 1) { IntArray(len2 + 1) }
    for (i in 0..len1) {
        for (j in 0..len2) {
            if (i == 0) {
                dp[i][j] = j
                continue
            }
            if (j == 0) {
                dp[i][j] = i
                continue
            }
            if (word1[i - 1] == word2[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1]
            } else {
                dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]))
            }
        }
    }
    return dp[len1][len2]
}