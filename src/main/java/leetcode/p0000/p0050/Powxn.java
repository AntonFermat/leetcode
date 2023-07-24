package leetcode.p0000.p0050;

public class Powxn {

    public double myPow(double x, int n) {
        if (n == 0) return 1;
        else if (n > 0) {
            var n2 = myPow(x, n / 2);
            return n2 * n2 * ((n % 2 == 1) ? x : 1);
        } else {
            var n2 = myPow(x, n / 2);
            return n2 * n2 * ((n % 2 == -1) ? (1 / x) : 1);
        }
    }
}
