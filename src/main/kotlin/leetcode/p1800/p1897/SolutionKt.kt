package leetcode.p1800.p1897

class SolutionKt {
    fun makeEqual(words: Array<String>): Boolean =
        words.flatMap { it.map { it } }.groupingBy { it }.eachCount().values.all { it % words.size == 0 }
}