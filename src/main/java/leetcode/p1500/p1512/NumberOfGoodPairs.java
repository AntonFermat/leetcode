package leetcode.p1500.p1512;

public class NumberOfGoodPairs {
    public int numIdenticalPairs(int[] nums) {
        var count = new int[101];
        int res = 0;
        for (int num : nums) res += count[num]++;
        return res;
    }
}
