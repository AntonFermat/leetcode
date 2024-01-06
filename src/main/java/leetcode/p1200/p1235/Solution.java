package leetcode.p1200.p1235;

import java.util.*;

public class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int len = startTime.length;
        var jobs = new ArrayList<Job>();
        for (int i = 0; i < len; i++) jobs.add(new Job(startTime[i], endTime[i], profit[i]));
        jobs.sort(Comparator.comparingInt(j -> j.end));
        var map = new TreeMap<>(Map.of(0, 0));
        for (var job : jobs) {
            var curProfit = map.floorEntry(job.start).getValue() + job.profit;
            if (curProfit > map.lastEntry().getValue()) {
                map.put(job.end, curProfit);
            }
        }
        return map.lastEntry().getValue();
    }

    private record Job(int start, int end, int profit) {
    }
}
