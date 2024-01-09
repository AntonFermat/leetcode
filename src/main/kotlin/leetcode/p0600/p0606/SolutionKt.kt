package leetcode.p0600.p0606

import leetcode.TreeNode

class SolutionKt {
    fun tree2str(root: TreeNode?): String =
        buildString {
            append(root!!.`val`)
            append(root.left?.let { "(${tree2str(root.left)})" } ?: run { "" })
            append(if (root.left == null && root.right != null) "()" else "")
            append(root.right?.let { "(${tree2str(root.right)})" } ?: run { "" })
        }
}