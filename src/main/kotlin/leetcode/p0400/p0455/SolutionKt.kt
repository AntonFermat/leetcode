package leetcode.p0400.p0455

import java.util.*

class SolutionKt {
    fun findContentChildren(g: IntArray, s: IntArray): Int {
        Arrays.sort(g)
        Arrays.sort(s)
        var res = 0
        var index = 0
        while (index < s.size && res < g.size) {
            if (s[index] >= g[res]) res++
            index++
        }
        return res
    }
}