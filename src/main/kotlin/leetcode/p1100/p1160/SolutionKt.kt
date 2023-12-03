package leetcode.p1100.p1160

class SolutionKt {
    fun countCharacters(words: Array<String>, chars: String): Int =
        words.filter { w -> ('a'..'z').all { c -> chars.count { it == c } >= w.count { it == c } } }.sumOf { it.length }
}