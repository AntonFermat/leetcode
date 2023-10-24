package leetcode.p0500.p0515

import java.util.*
import kotlin.math.max

class SolutionKt {
    fun largestValues(root: TreeNode?): List<Int> {
        val res = ArrayList<Int>()
        val q = LinkedList<TreeNode?>()
        q.add(root)
        while (!q.isEmpty()) {
            var size = q.size
            var max = Integer.MIN_VALUE
            while (size-- > 0) {
                val cur = q.pop()!!
                max = max(max, cur.`val`)
                if (cur.left != null) q.add(cur.left)
                if (cur.right != null) q.add(cur.right)
            }
            res.add(max)
        }
        return res
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}