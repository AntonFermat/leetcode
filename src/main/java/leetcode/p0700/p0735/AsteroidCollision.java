package leetcode.p0700.p0735;

import java.util.Stack;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        var stack = new Stack<Integer>();
        for (var a : asteroids) {
            stack.add(a);
            while (stack.size() > 1 && stack.peek() < 0) {
                int r = stack.pop();
                int l = stack.pop();
                if (l + r == 0) break;
                if (l < 0) {
                    stack.add(l);
                    stack.add(r);
                    break;
                }
                stack.add(l + r > 0 ? l : r);
            }
        }

        int len = stack.size();
        var res = new int[len];
        for (int i = 0; i < len; i++) res[len - i - 1] = stack.pop();
        return res;
    }
}
