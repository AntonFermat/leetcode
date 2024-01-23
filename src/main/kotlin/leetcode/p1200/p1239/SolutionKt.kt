package leetcode.p1200.p1239


class SolutionKt {
    fun maxLength(arr: List<String>): Int {
        return helper(arr, 0, "")
    }

    private fun helper(arr: List<String>, index: Int, cur: String): Int {
        var res = cur.length
        if (index == arr.size) return res
        for (i in index..< arr.size) {
            val ncur = cur + arr[i]
            res = if (ncur.toSet().size == ncur.length) {
                maxOf(res, helper(arr, i + 1, ncur))
            } else {
                maxOf(res, helper(arr, i + 1, cur))
            }
        }
        return res
    }
}