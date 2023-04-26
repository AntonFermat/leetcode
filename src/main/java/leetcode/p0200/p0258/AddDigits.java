package leetcode.p0200.p0258;

public class AddDigits {
    public int addDigits(int num) {
        return num - 9 * ((num - 1) / 9);
    }
}
