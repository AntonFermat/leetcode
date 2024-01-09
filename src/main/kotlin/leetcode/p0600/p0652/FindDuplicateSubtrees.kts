import leetcode.TreeNode
import java.util.HashMap

fun findDuplicateSubtrees(root: TreeNode?): List<TreeNode>? {
    val res = ArrayList<TreeNode>()
    dfs(root, HashMap(), res)
    return res
}

fun dfs(node: TreeNode?, map: MutableMap<String, Int>, res: MutableList<TreeNode>): String {
    if (node == null) return "x"
    val serial = node.`val`.toString() + "(" + dfs(node.left, map, res) + " " + dfs(node.right, map, res) + ")"
    val count = map.getOrDefault(serial, 0)
    if (count == 1) res.add(node)
    if (count < 2) map[serial] = count + 1
    return serial
}