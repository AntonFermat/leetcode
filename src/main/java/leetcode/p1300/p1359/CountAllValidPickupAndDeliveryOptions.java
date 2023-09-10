package leetcode.p1300.p1359;

public class CountAllValidPickupAndDeliveryOptions {
    public int countOrders(int n) {
        return helper(n, n, new int[n + 1][n + 1]);
    }

    private int helper(int pickup, int delivery, int[][] memo) {
        if (pickup == 0 && delivery == 0) return 1;
        if (pickup > delivery) return 0;
        if (memo[pickup][delivery] != 0) return memo[pickup][delivery];
        int mod = 1_000_000_007;
        long res = 0;
        if (pickup > 0) res = (long) pickup * helper(pickup - 1, delivery, memo) % mod;
        res = (res + (long) (delivery - pickup) * helper(pickup, delivery - 1, memo)) % mod;
        return memo[pickup][delivery] = (int) res;
    }
}
