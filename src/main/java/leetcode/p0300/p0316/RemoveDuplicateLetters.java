package leetcode.p0300.p0316;

import java.util.*;

public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        var count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        var stack = new Stack<Character>();
        var visited = new HashSet<Character>();
        for (char c : s.toCharArray()) {
            while (!stack.isEmpty() && !visited.contains(c)
                    && count[stack.peek() - 'a'] > 0 && stack.peek() > c) {
                visited.remove(stack.pop());
            }

            if (!visited.contains(c)) {
                stack.add(c);
                visited.add(c);
            }
            count[c - 'a']--;
        }

        var sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }
}
