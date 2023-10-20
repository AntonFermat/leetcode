package leetcode.p0300.p0341;

import java.util.*;

public class NestedIterator implements Iterator<Integer> {

    public NestedIterator(List<NestedInteger> nestedList) {
        this.iter = nestedList.listIterator();
    }

    final private Iterator<NestedInteger> iter;
    private NestedIterator curIter;
    private Integer curInt;

    @Override
    public Integer next() {
        if (hasNext()) {
            if (curInt != null) {
                int val = curInt;
                curInt = null;
                return val;
            } else return curIter.next();
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        if (curInt != null) return true;
        else {
            if (curIter == null || !curIter.hasNext()) {
                if (!iter.hasNext()) return false;
                var next = iter.next();
                if (next.isInteger()) {
                    curInt = next.getInteger();
                    return true;
                }
                curIter = new NestedIterator(next.getList());
                if (curIter.hasNext()) return true;
                else {
                    curIter = null;
                    return hasNext();
                }
            }
        }
        return true;
    }
}