package leetcode.p1300.p1361;

import java.util.*;

public class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        var degree = new int[n];
        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1 && ++degree[leftChild[i]] > 2) return false;
            if (rightChild[i] != -1 && ++degree[rightChild[i]] > 2) return false;
        }
        var q = new LinkedList<Integer>();
        var v = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 0) {
                if (q.size() == 1) return false;
                q.add(i);
            }
        }
        if (q.isEmpty()) return false;

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (v.contains(cur)) return false;
            v.add(cur);

            int left = leftChild[cur];
            if (left != -1) {
                q.add(left);
            }
            int right = rightChild[cur];
            if (right != -1) {
                q.add(right);
            }
        }
        return v.size() == n;
    }
}
