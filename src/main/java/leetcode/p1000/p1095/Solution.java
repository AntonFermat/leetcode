package leetcode.p1000.p1095;

public class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int len = mountainArr.length();
        int peak = 0;
        int l = 0, r = len - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (m == len - 1) {
                peak = len - 1;
            } else {
                int cur = mountainArr.get(m);
                int next = mountainArr.get(m + 1);
                if (cur < next) {
                    l = m + 1;
                    peak = m + 1;
                } else {
                    r = m - 1;
                    peak = m;
                }
            }
        }
        int res = findInMountainArray(target, mountainArr, 0, peak, true);
        if (res != -1) return res;
        return findInMountainArray(target, mountainArr, peak, len - 1, false);
    }

    private int findInMountainArray(int target, MountainArray mountainArr, int l, int r, boolean asc) {
        while (l <= r) {
            int m = l + (r - l) / 2;
            int val = mountainArr.get(m);
            if (val == target) return m;
            else if (asc && val > target || !asc && val < target) r = m - 1;
            else l = m + 1;
        }
        return -1;
    }

    private interface MountainArray {
        int get(int k);

        int length();
    }
}
