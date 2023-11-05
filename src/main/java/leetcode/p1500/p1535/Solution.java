package leetcode.p1500.p1535;

public class Solution {
    public int getWinner(int[] arr, int k) {
        int cur = arr[0], count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int max = Math.max(cur, Math.max(arr[i], arr[i + 1]));
            if (max == cur) count++;
            else {
                cur = max;
                count = 1;
            }
            if (count == k) return cur;
        }
        return cur;
    }
}
