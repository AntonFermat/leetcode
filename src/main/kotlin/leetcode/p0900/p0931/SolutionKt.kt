package leetcode.p0900.p0931

import java.util.*
import kotlin.math.max
import kotlin.math.min


class SolutionKt {
    fun minFallingPathSum(matrix: Array<IntArray>): Int {
        val n = matrix.size
        for (i in 1 ..<n) {
            for (j in 0..<n) {
                matrix[i][j] += min(
                    matrix[i - 1][j], min(
                        matrix[i - 1][max(0, j - 1)],
                        matrix[i - 1][min(n - 1, j + 1)]
                    )
                )
            }
        }
        return Arrays.stream(matrix[n - 1]).min().asInt
    }
}