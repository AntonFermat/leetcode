package leetcode.p2300.p2353;

import java.util.*;

public class FoodRatings {
    private final Map<String, String> foodCuisine = new HashMap<>();
    private final Map<String, Integer> foodRating = new HashMap<>();
    private final Map<String, TreeMap<Integer, TreeSet<String>>> cuisineRating = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        int len = foods.length;
        for (int i = 0; i < len; i++) {
            var f = foods[i];
            var c = cuisines[i];
            var r = ratings[i];
            foodCuisine.put(f, c);
            foodRating.put(f, r);
            cuisineRating.computeIfAbsent(c, o -> new TreeMap<>()).computeIfAbsent(r, o -> new TreeSet<>()).add(f);
        }
    }

    public void changeRating(String food, int newRating) {
        String c = foodCuisine.get(food);
        int r = foodRating.get(food);
        foodRating.put(food, newRating);
        cuisineRating.get(c).get(r).remove(food);
        if (cuisineRating.get(c).get(r).isEmpty()) cuisineRating.get(c).remove(r);
        cuisineRating.get(c).computeIfAbsent(newRating, o -> new TreeSet<>()).add(food);
    }

    public String highestRated(String cuisine) {
        return cuisineRating.get(cuisine).lastEntry().getValue().first();
    }
}
