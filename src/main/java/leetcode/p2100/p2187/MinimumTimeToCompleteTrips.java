package leetcode.p2100.p2187;

import java.util.*;

public class MinimumTimeToCompleteTrips {
    public long minimumTime(int[] time, int totalTrips) {
        Arrays.sort(time);
        int len = time.length;
        long l = 1, r = (long) time[0] * totalTrips;
        while (l < r) {
            long m = l + (r - l) / 2;
            boolean isPossible = false;
            int trips = 0;
            for (int t : time) {
                trips += m / t;
                if (trips >= totalTrips) {
                    isPossible = true;
                    break;
                }
            }
            if (isPossible) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return r;
    }
}
