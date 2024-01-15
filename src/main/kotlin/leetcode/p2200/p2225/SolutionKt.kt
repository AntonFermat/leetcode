package leetcode.p2200.p2225

import java.util.*

class SolutionKt {
    fun findWinners(matches: Array<IntArray>): List<List<Int>> {
        val map = TreeMap<Int, Int>()
        matches.forEach {
            map.putIfAbsent(it[0], 0)
            map.merge(it[1], 1, Int::plus)
        }
        return listOf(
            map.filter { (_, v) -> v == 0 }.keys.toList(),
            map.filter { (_, v) -> v == 1 }.keys.toList()
        )
    }
}