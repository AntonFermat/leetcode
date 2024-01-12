package leetcode.p1700.p1704

class SolutionKt {
    fun halvesAreAlike(s: String): Boolean =
        s.withIndex().sumOf { (2 * (it.index / (s.length / 2)) - 1) * false.compareTo(setOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U').contains(it.value)) } == 0
}