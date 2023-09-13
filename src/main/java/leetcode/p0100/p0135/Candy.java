package leetcode.p0100.p0135;

import java.util.Arrays;

public class Candy {
    public int candy(int[] ratings) {
        int len = ratings.length;
        var res = new int[len];
        Arrays.fill(res, 1);
        res[0] = 1;
        for (int i = 1; i < len; i++) {
            if (ratings[i] > ratings[i - 1]) res[i] = res[i - 1] + 1;
        }

        for (int i = len - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) res[i] = Math.max(res[i + 1] + 1, res[i]);
        }

        return Arrays.stream(res).sum();
    }
}
