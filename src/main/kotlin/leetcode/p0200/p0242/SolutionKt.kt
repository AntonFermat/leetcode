package leetcode.p0200.p0242

class SolutionKt {
    fun isAnagram(s: String, t: String): Boolean = s.toCharArray().sorted() == t.toCharArray().sorted()
}