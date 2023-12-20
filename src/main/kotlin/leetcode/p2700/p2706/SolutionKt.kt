package leetcode.p2700.p2706

class SolutionKt {
    fun buyChoco(prices: IntArray, money: Int): Int =
        prices.sorted().let { if (money - it[0] - it[1] < 0) money else money - it[0] - it[1] }
}