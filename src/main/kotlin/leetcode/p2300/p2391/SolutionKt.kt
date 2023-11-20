package leetcode.p2300.p2391

class SolutionKt {
    fun garbageCollection(garbage: Array<String>, travel: IntArray): Int =
        garbage.reversed().foldIndexed(listOf(0, 0, 0, 0)) { i, l, it ->
            listOf(
                l[0] + it.length + (l[1] + l[2] + l[3]) * travel.getOrElse(garbage.size - i - 1) { 0 },
                l[1] or (if ('M' in it) 1 else 0),
                l[2] or (if ('P' in it) 1 else 0),
                l[3] or (if ('G' in it) 1 else 0)
            )
        }[0]

    fun garbageCollection1(garbage: Array<String>, travel: IntArray): Int =
        garbage.foldIndexed(listOf(0, 0, 0, 0)) { i, l, it ->
            listOf(
                l[0] + it.length + (if ('M' in it) l[1] + travel.getOrElse(i - 1) { 0 } else 0)
                        + (if ('P' in it) l[2] + travel.getOrElse(i - 1) { 0 } else 0)
                        + (if ('G' in it) l[3] + travel.getOrElse(i - 1) { 0 } else 0),
                if ('M' in it) 0 else l[1] + travel.getOrElse(i - 1) { 0 },
                if ('P' in it) 0 else l[2] + travel.getOrElse(i - 1) { 0 },
                if ('G' in it) 0 else l[3] + travel.getOrElse(i - 1) { 0 },
            )
        }[0]
}