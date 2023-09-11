package leetcode.p1200.p1282;

import java.util.*;

public class GroupThePeopleGivenTheGroupSizeTheyBelongTo {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        var res = new ArrayList<List<Integer>>();
        var map = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < groupSizes.length; i++) {
            var gs = groupSizes[i];
            var list = map.computeIfAbsent(gs, o -> new ArrayList<>());
            list.add(i);
            if (list.size() == gs) {
                res.add(new ArrayList<>(list));
                list.clear();
            }
        }
        return res;
    }
}
