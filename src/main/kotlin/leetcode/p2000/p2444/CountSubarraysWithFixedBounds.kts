fun countSubarrays(nums: IntArray, minK: Int, maxK: Int): Long {
    var res: Long = 0
    val len = nums.size
    var minKPos = -1
    var maxKPos = -1
    var leftPos = -1
    val prev = -1
    for (i in 0 until len) {
        val num = nums[i]
        if (num < minK || num > maxK) leftPos = i
        if (num == minK) minKPos = i
        if (num == maxK) maxKPos = i
        val rightPos = Math.min(minKPos, maxKPos)
        if (rightPos > leftPos) res += (rightPos - leftPos).toLong()
    }
    return res
}