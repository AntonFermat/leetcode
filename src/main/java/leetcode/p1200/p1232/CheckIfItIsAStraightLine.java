package leetcode.p1200.p1232;

public class CheckIfItIsAStraightLine {
    public boolean checkStraightLine(int[][] c) {
        if (c.length == 2) return true;
        int xDiff = c[0][0] - c[1][0];
        int yDiff = c[0][1] - c[1][1];
        for (int i = 2; i < c.length; i++) {
            if (xDiff * (c[0][1] - c[i][1]) != (c[0][0] - c[i][0]) * yDiff) return false;
        }
        return true;
    }
}
