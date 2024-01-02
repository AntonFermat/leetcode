package leetcode.p2600.p2610

class SolutionKt {
    fun findMatrix(nums: IntArray): List<List<Int>> {
        val res = ArrayList<MutableList<Int>>()
        val count = IntArray(nums.size + 1)
        for (num in nums) {
            if (count[num] >= res.size) res.add(ArrayList())
            res[count[num]].add(num)
            count[num]++
        }
        return res
    }
}