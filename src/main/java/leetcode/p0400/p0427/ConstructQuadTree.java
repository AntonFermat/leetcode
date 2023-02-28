package leetcode.p0400.p0427;

public class ConstructQuadTree {

    private int[][] grid;

    public Node construct(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        this.grid = grid;
        return construct(0, 0, m, n);
    }

    private Node construct(int i1, int j1, int i2, int j2) {
        if (check(i1, j1, i2, j2)) return new Node(grid[i1][j1] == 1, true);

        int mid = (i2 - i1) / 2;
        var node = new Node();
        node.topLeft = construct(i1, j1, i1 + mid, j1 + mid);
        node.topRight = construct(i1, j1 + mid, i1 + mid, j2);
        node.bottomLeft = construct(i1 + mid, j1, i2, j1 + mid);
        node.bottomRight = construct(i1 + mid, j1 + mid, i2, j2);
        return node;
    }

    private boolean check(int i1, int j1, int i2, int j2) {
        int x = grid[i1][j1];
        for (int i = i1; i < i2; i++) {
            for (int j = j1; j < j2; j++) {
                if (x != grid[i][j]) return false;
            }
        }
        return true;
    }

    private static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }
}
