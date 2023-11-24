package leetcode.p1500.p1561

class SolutionKt {
    fun maxCoins(piles: IntArray): Int = piles.sorted().slice((piles.size / 3) until piles.size step 2).sum()
}