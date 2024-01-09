package leetcode.p0900.p0938

import leetcode.TreeNode

class SolutionKt {
    fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {
        if (root == null) return 0
        return (if (root.`val` <= low) 0 else rangeSumBST(root.left, low, high)) +
                (if (root.`val` >= high) 0 else rangeSumBST(root.right, low, high)) +
                if (root.`val` in low..high) root.`val` else 0
    }
}