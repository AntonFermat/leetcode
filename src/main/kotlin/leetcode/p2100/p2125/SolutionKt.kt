package leetcode.p2100.p2125

fun main() {
    SolutionKt().numberOfBeams(arrayOf("011001", "000000", "010100", "001000"))
}

class SolutionKt {
    fun numberOfBeams(bank: Array<String>): Int =
        bank.map { it.count { c -> c > '0' } }.filter { it > 0 }.zipWithNext { f, s -> f * s }.sum()
}