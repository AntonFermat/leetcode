package leetcode.p0800.p0867

class SolutionKt {
    fun transpose(matrix: Array<IntArray>): Array<IntArray> =
        Array(matrix[0].size) { row -> IntArray(matrix.size) { col -> matrix[col][row] } }
}