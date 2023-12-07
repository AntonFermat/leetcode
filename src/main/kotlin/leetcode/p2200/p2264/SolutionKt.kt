package leetcode.p2200.p2264

class SolutionKt {
    fun largestGoodInteger(num: String): String = (0..num.length - 3).fold("") { acc, i ->
        if (num[i] == num[i + 1] && num[i + 1] == num[i + 2] && acc < num.substring(i..i + 2)) num.substring(i..i + 2) else acc
    }
}