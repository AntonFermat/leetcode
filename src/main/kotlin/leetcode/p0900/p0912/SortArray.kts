fun sortArray(nums: IntArray): IntArray? {
    mergeSort(nums)
    //heapSort(nums);
    return nums
}

fun mergeSort(nums: IntArray) {
    mergeSort(nums, IntArray(nums.size), 0, nums.size - 1)
}

fun mergeSort(nums: IntArray, tmp: IntArray, l: Int, r: Int) {
    if (l >= r) return
    val m = l + (r - l) / 2
    mergeSort(nums, tmp, l, m)
    mergeSort(nums, tmp, m + 1, r)
    merge(nums, tmp, l, r)
}

fun merge(nums: IntArray, tmp: IntArray, l: Int, r: Int) {
    val m = l + (r - l) / 2
    for (i in l..m) tmp[i] = nums[i]
    for (i in m + 1..r) tmp[i] = nums[i]
    var i = l
    var j = m + 1
    var k = l
    while (k <= r) {
        if ((i > m || j <= r) && tmp[i] > tmp[j]) {
            nums[k] = tmp[j]
            j++
        } else {
            nums[k] = tmp[i]
            i++
        }
        k++
    }
}

fun heapSort(nums: IntArray) {
    val len = nums.size
    for (i in len / 2 - 1 downTo 0) {
        heap(nums, len, i)
    }
    for (i in len - 1 downTo 0) {
        val tmp = nums[0]
        nums[0] = nums[i]
        nums[i] = tmp
        heap(nums, i, 0)
    }
}

fun heap(nums: IntArray, n: Int, i: Int) {
    var largest = i
    val l = 2 * i + 1
    val r = 2 * i + 2
    if (l < n && nums[l] > nums[largest]) largest = l
    if (r < n && nums[r] > nums[largest]) largest = r
    if (largest != i) {
        val tmp = nums[largest]
        nums[largest] = nums[i]
        nums[i] = tmp
        heap(nums, n, largest)
    }
}