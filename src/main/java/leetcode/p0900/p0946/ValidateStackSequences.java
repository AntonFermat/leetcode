package leetcode.p0900.p0946;

import java.util.Stack;

public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int i = 0, j = 0;
        int len = pushed.length;
        var stack = new Stack<Integer>();
        while (i < len || j < len) {
            if (stack.isEmpty()) {
                stack.push(pushed[i++]);
            } else if (j < len && stack.peek() == popped[j]) {
                stack.pop();
                j++;
                if (j == len && i < len) return false;
            } else {
                if (i == len) return false;
                stack.push(pushed[i++]);
            }
        }
        return i == len && j == len;
    }
}
