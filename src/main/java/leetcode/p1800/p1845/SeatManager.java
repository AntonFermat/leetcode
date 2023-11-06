package leetcode.p1800.p1845;

import java.util.TreeSet;

public class SeatManager {
    private final TreeSet<Integer> set = new TreeSet<>();

    public SeatManager(int n) {
        for (int i = 1; i < n; i++) set.add(i);
    }

    public int reserve() {
        return set.pollFirst();
    }

    public void unreserve(int seatNumber) {
        set.add(seatNumber);
    }
}
