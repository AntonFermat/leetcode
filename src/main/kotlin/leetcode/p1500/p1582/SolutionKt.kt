package leetcode.p1500.p1582

class SolutionKt {
    fun numSpecial(mat: Array<IntArray>): Int =
        mat.mapNotNull { r -> if (r.sum() == 1) r.indexOfFirst { it == 1 } else null }
            .count { c -> mat.sumOf { it[c] } == 1 }
}