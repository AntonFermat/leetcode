package leetcode.p2400.p2433

class SolutionKt {
    fun findArray(pref: IntArray): IntArray = IntArray(pref.size) { pref[it] xor pref.getOrElse(it - 1) { 0 } }
}