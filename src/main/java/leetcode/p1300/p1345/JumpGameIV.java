package leetcode.p1300.p1345;

import java.util.*;

public class JumpGameIV {
    public int minJumps(int[] arr) {
        int len = arr.length;
        var map = new HashMap<Integer, Set<Integer>>();
        for (int i = 0; i < len; i++) {
            int a = arr[i];
            map.computeIfAbsent(a, o -> new HashSet<>()).add(i);
        }

        var q = new LinkedList<Integer>();
        var visited = new HashSet<Integer>();
        q.add(0);
        visited.add(0);
        int res = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                var cur = q.poll();
                if (cur == len - 1) return res;
                if (cur + 1 < len && !visited.contains(cur + 1)) {
                    q.add(cur + 1);
                    visited.add(cur + 1);
                }
                if (cur - 1 > 0 && !visited.contains(cur - 1)) {
                    q.add(cur - 1);
                    visited.add(cur - 1);
                }
                for (var next : map.get(arr[cur])) {
                    if (!visited.contains(next)) {
                        q.add(next);
                        visited.add(next);
                    }
                }
                map.get(arr[cur]).clear();
            }
            res++;
        }
        return -1;
    }
}
