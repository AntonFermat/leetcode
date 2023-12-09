package leetcode.p0000.p0094

class SolutionKt {
    fun inorderTraversal(root: TreeNode?): List<Int> = root?.let {
        buildList {
            addAll(inorderTraversal(root.left))
            add(root.`val`)
            addAll(inorderTraversal(root.right))
        }
    } ?: run { emptyList() }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}