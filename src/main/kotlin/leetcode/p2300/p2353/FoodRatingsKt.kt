package leetcode.p2300.p2353

import java.util.*

class FoodRatingsKt(foods: Array<String>, cuisines: Array<String>, ratings: IntArray) {
    private val foodCuisine = HashMap<String, String>()
    private val foodRating = HashMap<String, Int>()
    private val cuisineRating = HashMap<String, TreeMap<Int, TreeSet<String>>>()

    init {
        val len = foods.size
        for (i in 0..<len) {
            foodCuisine[foods[i]] = cuisines[i]
            foodRating[foods[i]] = ratings[i]
            cuisineRating
                .computeIfAbsent(cuisines[i]) { o -> TreeMap() }
                .computeIfAbsent(ratings[i]) { o -> TreeSet() }.add(foods[i])
        }
    }

    fun changeRating(food: String, newRating: Int) {
        val c = foodCuisine[food]
        val r = foodRating[food]
        foodRating[food] = newRating
        cuisineRating[c]!![r]!!.remove(food)
        if (cuisineRating[c]!![r]!!.isEmpty()) cuisineRating[c]!!.remove(r)
        cuisineRating[c]!!.computeIfAbsent(newRating) { o -> TreeSet() }.add(food)
    }

    fun highestRated(cuisine: String): String {
        return cuisineRating[cuisine]!!.lastEntry().value.first()
    }
}