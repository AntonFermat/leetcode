package leetcode.p0900.p0935

class SolutionKt {
    fun knightDialer(n: Int): Int {
        return if (n == 1) return 10 else ((0..n - 2).fold(listOf(4L, 2, 2, 1)) { l, _ ->
            listOf(2 * l[1] + 2 * l[2], l[0], l[0] + 2 * l[3], l[2]).map { it % 1_000_000_007 }
        }.sum() % 1_000_000_007).toInt()
    }
}