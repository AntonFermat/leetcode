package leetcode.p1200.p1287;

public class Solution {
    public int findSpecialInteger(int[] arr) {
        int count = 1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                count++;
                if (count == 1 + arr.length / 4) return arr[i];
            } else count = 1;
        }
        return arr[arr.length - 1];
    }
}
