package leetcode.p0700.p0779

class SolutionKt {
    fun kthGrammar(n: Int, k: Int): Int {
        if (n == 1) return 0
        return if (k % 2 == 0) {
            if (kthGrammar(n - 1, k / 2) % 2 == 0) 1 else 0
        } else {
            if (kthGrammar(n - 1, (k + 1) / 2) % 2 == 0) 0 else 1
        }
    }
}