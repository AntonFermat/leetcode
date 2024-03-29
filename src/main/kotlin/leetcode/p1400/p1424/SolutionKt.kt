package leetcode.p1400.p1424

import java.util.*

class SolutionKt {
    fun findDiagonalOrder(nums: List<List<Int>>): IntArray = nums.indices
        .flatMap { r -> nums[r].indices.map { c -> r to c } }
        .fold(TreeMap<Int, MutableList<Int>>()) { map, (r, c) ->
            map.apply { getOrPut(r + c) { mutableListOf() }.add(nums[r][c]) }
        }.values.flatMap { it.reversed() }.toIntArray()

    fun findDiagonalOrder1(nums: List<List<Int>>): IntArray {
        val q = LinkedList(listOf(0 to 0))
        val res = ArrayList<Int>()
        while (!q.isEmpty()) {
            val p = q.poll()
            res.add(nums[p.first][p.second])
            if (p.second == 0 && p.first + 1 < nums.size) q.add(p.first + 1 to 0)
            if (p.second + 1 < nums[p.first].size) q.offer(p.first to p.second + 1)
        }
        return res.toIntArray()
    }
}