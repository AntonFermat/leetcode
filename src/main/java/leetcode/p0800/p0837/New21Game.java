package leetcode.p0800.p0837;

public class New21Game {
    public double new21Game(int n, int k, int maxPts) {
        var prob = new double[n + 1];
        prob[0] = 1;
        double cur = (k == 0) ? 0 : 1;
        for (int i = 1; i <= n; i++) {
            prob[i] = cur / maxPts;
            if (i < k) cur += prob[i];
            if (i >= maxPts && i < maxPts + k) cur -= prob[i - maxPts];
        }


        double res = 0.0;
        for (int i = k; i <= n; i++) res += prob[i];
        return res;
    }
}
