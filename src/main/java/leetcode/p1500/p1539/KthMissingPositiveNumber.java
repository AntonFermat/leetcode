package leetcode.p1500.p1539;

public class KthMissingPositiveNumber {
    public int findKthPositive(int[] arr, int k) {
        int l = 0, r = arr.length;
        while (l < r) {
            int m = (l + r) / 2;
            if (arr[m] - 1 - m < k) l = m + 1;
            else r = m;
        }
        return l + k;
    }
}
