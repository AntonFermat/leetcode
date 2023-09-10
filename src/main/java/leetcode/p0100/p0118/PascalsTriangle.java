package leetcode.p0100.p0118;

import java.util.*;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        var res = new ArrayList<List<Integer>>();
        var row = new ArrayList<Integer>();
        for (int i = 0; i < numRows; i++) {
            row.add(0, 1);
            for (int j = 1; j < row.size() - 1; j++) {
                row.set(j, row.get(j) + row.get(j + 1));
            }
            res.add(new ArrayList<>(row));
        }
        return res;
    }
}
