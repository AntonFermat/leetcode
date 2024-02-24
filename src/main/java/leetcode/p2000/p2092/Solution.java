package leetcode.p2000.p2092;

import java.util.*;

public class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        var map = new HashMap<Integer, List<Pair>>();
        for (int[] m : meetings) {
            map.computeIfAbsent(m[0], o -> new ArrayList<>()).add(new Pair(m[1], m[2]));
            map.computeIfAbsent(m[1], o -> new ArrayList<>()).add(new Pair(m[0], m[2]));
        }

        int[] time = new int[n];
        Arrays.fill(time, Integer.MAX_VALUE);
        time[0] = 0;
        time[firstPerson] = 0;

        var q = new LinkedList<Pair>();
        q.offer(new Pair(0, 0));
        q.offer(new Pair(firstPerson, 0));

        while (!q.isEmpty()) {
            var cur = q.poll();
            if (map.containsKey(cur.a)) {
                for (var next : map.get(cur.a)) {
                    if (next.b >= cur.b && time[next.a] > next.b) {
                        time[next.a] = next.b;
                        q.offer(new Pair(next.a, next.b));
                    }
                }
            }
        }

        var res = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (time[i] != Integer.MAX_VALUE) res.add(i);
        }
        return res;
    }

    private record Pair(int a, int b) {

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return a == pair.a && b == pair.b;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }
    }
}
