class Solution {
    fun kWeakestRows(mat: Array<IntArray>, k: Int): IntArray = mat.withIndex().sortedBy { it.value.sum() }.take(k).map { it.index }.toIntArray()
}