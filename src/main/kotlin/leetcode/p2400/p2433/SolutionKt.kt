package leetcode.p2400.p2433

class SolutionKt {
    fun findArray(pref: IntArray): IntArray {
        val res = IntArray(pref.size)
        res[0] = pref[0]
        for (i in 1 until pref.size) res[i] = pref[i - 1] xor pref[i]
        return res
    }
}