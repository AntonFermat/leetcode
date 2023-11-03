package leetcode.p1400.p1441

class SolutionKt {
    fun buildArray(target: IntArray, n: Int): List<String> {
        val res = ArrayList<String>()
        var (i, j) = listOf(0, 0)
        while (++i <= n && j < target.size) {
            res.add("Push")
            if (i != target[j]) res.add("Pop") else j++
        }
        return res
    }
}