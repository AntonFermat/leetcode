package leetcode.p0800.p0852;

public class PeakIndexInAMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
        int l = 1, r = arr.length - 2;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m - 1] < arr[m] && arr[m] > arr[m + 1]) return m;
            else if (arr[m - 1] < arr[m] && arr[m] < arr[m + 1]) l = m + 1;
            else r = m - 1;
        }
        return -1;
    }
}
