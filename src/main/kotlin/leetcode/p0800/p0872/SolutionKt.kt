package leetcode.p0800.p0872

class SolutionKt {
    fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
        val q1 = ArrayDeque(listOf(root1))
        val q2 = ArrayDeque(listOf(root2))
        while (!q1.isEmpty()) {
            val node1 = q1.removeFirstOrNull()
            if (node1?.left == null && node1?.right == null) {
                var check = false
                while (!q2.isEmpty()) {
                    val node2 = q2.removeFirstOrNull()
                    if (node2?.left == null && node2?.right == null) {
                        check = node1?.`val` == node2?.`val`
                        break
                    }
                    if (node2.right != null) q2.addFirst(node2.right)
                    if (node2.left != null) q2.addFirst(node2.left)
                }
                if (!check) return false
            }

            if (node1?.right != null) q1.addFirst(node1.right)
            if (node1?.left != null) q1.addFirst(node1.left)
        }
        return q2.isEmpty()
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}