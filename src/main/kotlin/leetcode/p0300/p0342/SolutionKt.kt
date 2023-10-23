package leetcode.p0300.p0342

class SolutionKt {
    fun isPowerOfFour(n: Int): Boolean {
        return (n and n - 1 == 0) && (n % 3 == 1)
    }
}