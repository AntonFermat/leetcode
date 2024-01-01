package leetcode.p1600.p1624

class SolutionKt {
    fun maxLengthBetweenEqualCharacters(s: String) =
        s.withIndex().groupBy({ it.value }, { it.index })
            .maxOf { it.value.last() - it.value.first() - 1 }
}