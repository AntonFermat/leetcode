package leetcode.p1600.p1611

class SolutionKt {
    fun minimumOneBitOperations(n: Int): Int = if (n == 0) 0 else n xor minimumOneBitOperations(n / 2)
}