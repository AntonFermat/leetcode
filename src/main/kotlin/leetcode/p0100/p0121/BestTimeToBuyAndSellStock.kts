fun maxProfit(prices: IntArray): Int {
    var res = 0
    var min = Int.MAX_VALUE
    for (price in prices) {
        if (price < min) min = price
        if (res < price - min) res = price - min
    }
    return res
}