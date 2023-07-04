package leetcode.p0100.p0137;

public class SingleNumberII {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int shift = 1 << i;
            int x = 0;
            for (int num : nums) {
                if ((num & shift) != 0) x++;
            }
            if (x % 3 == 1) res |= shift;
        }
        return res;
    }
}
