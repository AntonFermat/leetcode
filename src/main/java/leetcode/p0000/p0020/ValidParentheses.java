package leetcode.p0000.p0020;

import java.util.*;

public class ValidParentheses {
    public boolean isValid(String s) {
        var stack = new Stack<Character>();
        for (var c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') stack.add(c);
            else if (stack.isEmpty() || c == ')' && stack.peek() != '('
                    || c == '}' && stack.peek() != '{'
                    || c == ']' && stack.peek() != '[') return false;
            else stack.pop();
        }
        return stack.isEmpty();
    }
}
