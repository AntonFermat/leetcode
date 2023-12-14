package leetcode.p2400.p2482

class SolutionKt {
    fun onesMinusZeros(grid: Array<IntArray>): Array<IntArray>? {
        val m = grid.size
        val n = grid[0].size
        val row = IntArray(m)
        val col = IntArray(n)
        for (i in 0 until m) {
            for (j in 0 until n) {
                row[i] += if (grid[i][j] == 1) 1 else -1
                col[j] += if (grid[i][j] == 1) 1 else -1
            }
        }
        val res = Array(m) { IntArray(n) }
        for (i in 0 ..< m) {
            for (j in 0..< n) res[i][j] = row[i] + col[j]
        }
        return res
    }
}