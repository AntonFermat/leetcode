package leetcode.p0500.p0501

import java.util.*

class SolutionKt {
    fun findMode(root: TreeNode?): IntArray {
        if (root == null) return IntArray(0)
        val map = HashMap<Int, Int>()
        val q = LinkedList<TreeNode>()
        val add = q.add(root)
        while (!q.isEmpty()) {
            val cur = q.poll()
            map[cur.`val`] = map.getOrDefault(cur.`val`, 0) + 1
            if (cur.left != null) q.add(cur.left!!)
            if (cur.right != null) q.add(cur.right!!)
        }
        val list = ArrayList<Int>()
        var max = 0
        for (entry in map) {
            if (entry.value > max) {
                max = entry.value
                list.clear()
                list.add(entry.key)
            } else if (entry.value == max) list.add(entry.key)
        }
        val res = IntArray(list.size)
        for (i in list.indices) res[i] = list[i]
        return res
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}