package leetcode.p2100.p2140;

public class SolvingQuestionsWithBrainpower {
    public long mostPoints(int[][] questions) {
        int len = questions.length;
        var memo = new long[len];
        for (int i = len - 1; i >= 0; i--) {
            long pts = questions[i][0];
            int next = i + questions[i][1] + 1;
            long prev1 = (i == len - 1) ? 0L : memo[i + 1];
            long prev2 = (next >= len) ? 0L : memo[next];

            memo[i] = Math.max(prev1, pts + prev2);
        }
        return memo[0];
    }
}
