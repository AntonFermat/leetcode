class NestedIterator(nestedList: List<NestedInteger>) {

    private var iter: Iterator<NestedInteger> = nestedList.listIterator()
    private var curIter: NestedIterator? = null
    private var curInt: Int? = null

    fun next(): Int {
        if (hasNext()) {
            if (curInt != null) {
                val tmp = curInt
                curInt = null
                return tmp!!
            } else return curIter!!.next()
        }
        throw RuntimeException()
    }

    fun hasNext(): Boolean {
        if (curInt != null) {
            return true
        } else {
            if (curIter == null || !curIter!!.hasNext()) {
                if (!iter.hasNext()) return false
                val next = iter.next()
                if (next.isInteger()) {
                    curInt = next.getInteger()
                    return true
                }
                curIter = NestedIterator(next.getList()!!)
                if (curIter!!.hasNext()) return true
                else {
                    curIter = null
                    return hasNext()
                }
            }
        }
        return true
    }
}

abstract class NestedInteger {
    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    abstract fun isInteger(): Boolean

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    abstract fun getInteger(): Int?

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    abstract fun add(ni: NestedInteger)

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    abstract fun getList(): List<NestedInteger>?
}