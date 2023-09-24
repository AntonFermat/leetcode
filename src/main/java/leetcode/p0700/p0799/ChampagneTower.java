package leetcode.p0700.p0799;

public class ChampagneTower {
    public double champagneTower(int poured, int query_row, int query_glass) {
        var curRow = new double[query_row + 1];
        curRow[0] = poured;
        for(int i = 0; i < query_row; i++) {
            var nextRow = new double[query_row + 1];
            for(int j = 0; j <= i; j++) {
                double rest = (curRow[j] - 1.0) / 2.0;
                if(rest > 0) {
                    nextRow[j] += rest;
                    nextRow[j + 1] += rest;
                }
            }
            curRow = nextRow;
        }
        return Math.min(1, curRow[query_glass]);
    }
}
