package leetcode.p1700.p1758

class SolutionKt {
    fun minOperations(s: String): Int {
        var res1 = 0
        var res2 = 0
        for (i in s.indices) {
            val c = s[i]
            val i1 = i % 2
            if (c == '1') res1 += i1 else res2 += i1
            if (c == '0') res1 += (1 - i1) else res2 += (1 - i1)
        }
        return Math.min(res1, res2)
    }
}