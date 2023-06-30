package leetcode.p1900.p1970;

import java.util.*;

public class LastDayWhereYouCanStillCross {
    public int latestDayToCross(int row, int col, int[][] cells) {
        this.row = row;
        this.col = col;
        int len = cells.length;
        for (int i = 0; i < len; i++) map.put(new Pair(cells[i][0] - 1, cells[i][1] - 1), i);

        int l = 0, r = len - 1;
        while (l < r) {
            int m = r - (r - l) / 2;
            boolean c = check(m);
            if (c) {
                l = m;
            } else r = m - 1;
        }
        return l;
    }

    private int row, col;
    private final Map<Pair, Integer> map = new HashMap<>();

    private boolean check(int index) {
        var q = new LinkedList<Pair>();
        var v = new HashSet<Pair>();
        for (int i = 0; i < col; i++) {
            var p = new Pair(0, i);
            if (map.containsKey(p) && map.get(p) < index) continue;
            q.add(p);
            v.add(p);
        }
        var dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while (!q.isEmpty()) {
            var cur = q.poll();
            if (cur.key() == row - 1) return true;
            for (int[] dir : dirs) {
                int newx = cur.key() + dir[0];
                int newy = cur.value() + dir[1];
                if (newx >= 0 && newx < row && newy >= 0 && newy < col) {
                    var next = new Pair(newx, newy);
                    if (v.contains(next) || (map.containsKey(next) && map.get(next) < index)) continue;
                    q.add(next);
                    v.add(next);
                }
            }
        }
        return false;
    }

    record Pair(int key, int value) {
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return key == pair.key && value == pair.value;
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }
    }
}
