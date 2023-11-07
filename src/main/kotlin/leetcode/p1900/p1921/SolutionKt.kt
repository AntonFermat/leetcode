package leetcode.p1900.p1921

class SolutionKt {
    fun eliminateMaximum(dist: IntArray, speed: IntArray): Int =
        dist.indices.map { (dist[it] + speed[it] - 1) / speed[it] }
            .sorted().withIndex().takeWhile { it.value > it.index }.count()
}