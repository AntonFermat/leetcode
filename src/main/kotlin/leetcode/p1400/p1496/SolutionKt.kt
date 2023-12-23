package leetcode.p1400.p1496

class SolutionKt {
    fun isPathCrossing(path: String): Boolean =
        path.length >= path.scan(0) { acc, it -> acc + if (it == 'N') 5000 else if (it == 'S') -5000 else if (it == 'W') 1 else -1 }
            .toSet().size
}