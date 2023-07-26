package leetcode.p1800.p1870;

public class MinimumSpeedToArriveOnTime {
    public int minSpeedOnTime(int[] dist, double hour) {
        int l = 1, r = 1_000_000_000;
        if (!isPossible(dist, hour, r)) return -1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (isPossible(dist, hour, m)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return r;
    }

    private boolean isPossible(int[] nums, double hour, int speed) {
        int len = nums.length;
        double max = 0.0;
        for (int i = 0; i < len - 1; i++) {
            max += (nums[i] + speed - 1) / speed;
        }
        max += ((double) nums[len - 1] / speed);

        return max <= hour;
    }
}
