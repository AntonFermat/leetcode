package leetcode.p1800.p1845

import java.util.*

class SeatManagerKt(n: Int) {
    val set = TreeSet(MutableList(n) { it + 1 })
    fun reserve(): Int = set.pollFirst()
    fun unreserve(seatNumber: Int) = set.add(seatNumber)
}