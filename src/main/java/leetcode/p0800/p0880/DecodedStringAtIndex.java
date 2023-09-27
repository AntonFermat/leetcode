package leetcode.p0800.p0880;

import java.util.Stack;

public class DecodedStringAtIndex {
    public String decodeAtIndex(String s, int k) {
        var stack = new Stack<Character>();
        long count = 0;
        for (char c : s.toCharArray()) {
            if (Character.isAlphabetic(c)) count++;
            else count *= (c - '0');
            stack.add(c);
            if (count >= k) break;
        }

        while (!stack.isEmpty()) {
            char c = stack.pop();
            if (Character.isAlphabetic(c)) {
                if (k == 0 || k == count) return String.valueOf(c);
                else count--;
            } else {
                count /= (c - '0');
                k %= count;
            }
        }
        return "";
    }
}
