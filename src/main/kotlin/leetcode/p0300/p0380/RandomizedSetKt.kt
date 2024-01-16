package leetcode.p0300.p0380

import java.util.Random

class RandomizedSetKt() {

    private val list: MutableList<Int> = mutableListOf()
    private val map: MutableMap<Int, Int> = mutableMapOf()
    private val rnd: Random = Random()

    fun insert(`val`: Int): Boolean {
        if (!map.containsKey(`val`)) {
            map[`val`] = list.size
            list.add(`val`)
            return true
        }
        return false
    }

    fun remove(`val`: Int): Boolean {
        val index = map[`val`]
        if (index != null) {
            list[index] = list[list.size - 1]
            list.removeAt(list.size - 1)
            map.remove(`val`)
            if (index < list.size) {
                map[list[index]] = index
            }
            return true
        }
        return false
    }

    fun getRandom(): Int {
        val index = rnd.nextInt(list.size)
        return list[index]
    }


}