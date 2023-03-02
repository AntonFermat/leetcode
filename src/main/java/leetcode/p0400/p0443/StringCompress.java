package leetcode.p0400.p0443;

public class StringCompress {
    public int compress(char[] chars) {
        int res = 0, count = 1;
        char prev = chars[0];
        for (int i = 1; i < chars.length; i++) {
            char cur = chars[i];
            if (prev != cur) {
                res = compress(chars, prev, count, res);
                count = 0;
                prev = cur;
            }
            count++;
        }
        return compress(chars, prev, count, res);
    }

    private int compress(char[] chars, char prev, int count, int res) {
        chars[res++] = prev;
        if (count > 1) {
            for (var d : String.valueOf(count).toCharArray()) {
                chars[res++] = d;
            }
        }
        return res;
    }
}
