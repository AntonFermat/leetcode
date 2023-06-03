package leetcode.p1300.p1396;

import java.util.*;

public class UndergroundSystem {
    private final Map<Integer, Pair<String, Integer>> checkIn = new HashMap<>();
    private final Map<Pair<String, String>, Double> sum = new HashMap<>();
    private final Map<Pair<String, String>, Integer> count = new HashMap<>();

    public UndergroundSystem() {

    }

    public void checkIn(int id, String stationName, int t) {
        checkIn.put(id, new Pair<>(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        if (checkIn.containsKey(id)) {
            var pair = checkIn.get(id);
            String start = pair.key();
            int startT = pair.value();
            var stations = new Pair<>(start, stationName);
            sum.put(stations, sum.getOrDefault(stations, 0.0) + (t - startT));
            count.put(stations, count.getOrDefault(stations, 0) + 1);

        }
    }

    public double getAverageTime(String startStation, String endStation) {
        var stations = new Pair<>(startStation, endStation);
        if (sum.containsKey(stations)) return sum.get(stations) / count.get(stations);
        return 0.0;
    }

    private record Pair<E, P>(E key, P value) {
    }
}
