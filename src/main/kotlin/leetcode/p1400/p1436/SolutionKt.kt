package leetcode.p1400.p1436

class SolutionKt {
    fun destCity(paths: List<List<String>>): String =
        paths.associateBy({ it[0] }, { it[1] }).let { map -> map.values.first { it !in map } }
}