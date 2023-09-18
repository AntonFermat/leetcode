package leetcode.p1300.p1337;

import java.util.*;
import java.util.stream.IntStream;

public class TheKWeakestRowsInAMatrix {
    public int[] kWeakestRows(int[][] mat, int k) {
        return IntStream.range(0, mat.length).boxed().
                sorted(Comparator.comparingInt(row -> Arrays.stream(mat[row]).sum())).mapToInt(i -> i)
                .limit(k).toArray();
    }
}
