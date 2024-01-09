package leetcode.p2200.p2265

import leetcode.TreeNode

class SolutionKt {
    var res = 0

    fun averageOfSubtree(root: TreeNode?): Int {
        if (root == null) return 0
        helper(root)
        return res
    }

    fun helper(node: TreeNode): IntArray {
        var sum = node.`val`
        var count = 1
        if (node.left != null) {
            val h = helper(node.left!!)
            sum += h[0]
            count += h[1]
        }

        if (node.right != null) {
            val h = helper(node.right!!)
            sum += h[0]
            count += h[1]
        }
        if (sum / count == node.`val`) res++
        return intArrayOf(sum, count)
    }
}