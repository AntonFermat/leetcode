package leetcode.p1300.p1356

class SolutionKt {
    fun sortByBits(arr: IntArray): IntArray {
        return arr.sortedWith { a, b ->
            val aBits = Integer.bitCount(a)
            val bBits = Integer.bitCount(b)
            when {
                aBits != bBits -> aBits - bBits
                else -> a - b
            }
        }.toIntArray()
    }
}