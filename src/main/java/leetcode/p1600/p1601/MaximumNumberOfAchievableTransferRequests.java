package leetcode.p1600.p1601;

public class MaximumNumberOfAchievableTransferRequests {
    public int maximumRequests(int n, int[][] requests) {
        int len = requests.length;
        helper(requests, new int[n], 0, 0);
        return res;
    }

    private int res = 0;

    private void helper(int[][] requests, int[] debt, int cur, int index) {
        int len = requests.length;
        int balance = 0;
        for (var d : debt) balance += Math.abs(d);
        if (balance == 0) res = Math.max(res, cur);

        if (index == len) return;
        for (int i = index; i < len; i++) {
            int from = requests[i][0];
            int to = requests[i][1];
            if (from == to) {
                helper(requests, debt, cur + 1, i + 1);
            } else {
                debt[from]--;
                debt[to]++;
                helper(requests, debt, cur + 1, i + 1);
                debt[from]++;
                debt[to]--;
            }
        }
    }
}
