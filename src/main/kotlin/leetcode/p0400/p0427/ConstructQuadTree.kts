private var grid: Array<IntArray>

fun construct(grid: Array<IntArray>): Node? {
    val m = grid.size
    val n = grid[0].size
    this.grid = grid
    return construct(0, 0, m, n)
}

open fun construct(i1: Int, j1: Int, i2: Int, j2: Int): Node? {
    if (check(i1, j1, i2, j2)) return Node(grid[i1][j1] == 1, true)
    val mid = (i2 - i1) / 2
    val node = Node()
    node.topLeft = construct(i1, j1, i1 + mid, j1 + mid)
    node.topRight = construct(i1, j1 + mid, i1 + mid, j2)
    node.bottomLeft = construct(i1 + mid, j1, i2, j1 + mid)
    node.bottomRight = construct(i1 + mid, j1 + mid, i2, j2)
    return node
}

open fun check(i1: Int, j1: Int, i2: Int, j2: Int): Boolean {
    val x = grid[i1][j1]
    for (i in i1 until i2) {
        for (j in j1 until j2) {
            if (x != grid[i][j]) return false
        }
    }
    return true
}

class Node(var `val`: Boolean, var isLeaf: Boolean) {
    var topLeft: Node? = null
    var topRight: Node? = null
    var bottomLeft: Node? = null
    var bottomRight: Node? = null
}