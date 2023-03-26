package leetcode.p0600.p0605;

public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] fl, int n) {
        int i = 0, c = 0;
        while (i < fl.length) {
            if (fl[i] == 0 && (i == 0 || fl[i - 1] == 0) && (i == fl.length - 1 || fl[i + 1] == 0)) {
                fl[i++] = 1;
                c++;
            }
            if (c >= n)
                return true;
            i++;
        }
        return false;
    }
}
