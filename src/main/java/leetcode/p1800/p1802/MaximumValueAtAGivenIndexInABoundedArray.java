package leetcode.p1800.p1802;

public class MaximumValueAtAGivenIndexInABoundedArray {
    public int maxValue(int n, int index, int maxSum) {
        int l = 0, r = maxSum;
        while (l < r) {
            int mid = r - (r - l) / 2;
            if (helper(n, index, maxSum, mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    private boolean helper(int n, int index, int maxSum, int num) {
        long sum = 0;
        int leftLen = index + 1;
        if (num <= leftLen) {
            sum += (leftLen - num) + (long) num * (num + 1) / 2;
        } else {
            sum += (leftLen) * (2L * num - index) / 2;
        }

        int rightLen = n - index;
        if (num <= rightLen) {
            sum += (n - index - num) + (long) num * (num + 1) / 2;
        } else {
            sum += rightLen * (2L * num - (rightLen - 1)) / 2;
        }
        return sum - num <= (long) maxSum;
    }
}
