package leetcode.p1900.p1964;

public class FindTheLongestValidObstacleCourseAtEachPosition {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int len = obstacles.length;
        var res = new int[len];
        int prevLen = 0;
        var prev = new int[len];
        for (var i = 0; i < len; i++) {
            int obstacle = obstacles[i];
            int index = find(prev, obstacle, prevLen);
            if (index == prevLen) prevLen++;
            prev[index] = obstacle;
            res[i] = index + 1;
        }
        return res;
    }

    private int find(int[] prev, int target, int index) {
        if (index == 0) return 0;
        int l = 0, r = index;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (prev[m] <= target) l = m + 1;
            else r = m;
        }
        return l;
    }
}
