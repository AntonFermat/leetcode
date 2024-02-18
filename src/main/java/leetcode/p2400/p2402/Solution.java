package leetcode.p2400.p2402;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

public class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(m -> m[0]));
        int max = 0;
        var rooms = new int[n];
        var usedRooms = new PriorityQueue<Pair>((p1, p2) -> p1.end == p2.end ? p1.index - p2.index : Long.compare(p1.end, p2.end));
        var unusedRooms = new PriorityQueue<Integer>();

        for (int i = 0; i < n; i++) unusedRooms.add(i);

        for (int[] meeting : meetings) {
            int start = meeting[0], end = meeting[1];

            while (!usedRooms.isEmpty() && usedRooms.peek().end <= start) {
                int room = usedRooms.poll().index;
                unusedRooms.offer(room);
            }

            if (!unusedRooms.isEmpty()) {
                int index = unusedRooms.poll();
                usedRooms.offer(new Pair(end, index));
                max = Math.max(max, ++rooms[index]);
            } else if (!usedRooms.isEmpty()) {
                Pair room = usedRooms.poll();
                usedRooms.offer(new Pair(room.end + end - start, room.index));
                max = Math.max(max, ++rooms[room.index]);
            }
        }

        for (int i = 0; i < n; i++) {
            if (rooms[i] == max) return i;
        }
        return 0;
    }

    record Pair(long end, int index) {
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return end == pair.end && index == pair.index;
        }

        @Override
        public int hashCode() {
            return Objects.hash(end, index);
        }
    }
}
