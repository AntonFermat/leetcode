package leetcode.p2100.p2147

class SolutionKt {
    fun numberOfWays(corridor: String): Int =
        if (corridor.count { it > 'P' } < 2 || corridor.count { it > 'P' } % 2 == 1) 0 else
            corridor.withIndex().filter { it.value > 'P' }.fold(listOf(0, 0, 1)) { l, it ->
                listOf(l[0] + 1, if (l[0] % 2 == 1) it.index else l[1], if (l[0] % 2 == 0 && l[0] > 0) (l[2].toLong() * (it.index - l[1]) % 1_000_000_007).toInt() else l[2])}[2]
}