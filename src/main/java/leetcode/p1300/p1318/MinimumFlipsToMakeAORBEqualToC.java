package leetcode.p1300.p1318;

public class MinimumFlipsToMakeAORBEqualToC {
    public int minFlips(int a, int b, int c) {
        int xor = (a | b) ^ c;
        return Integer.bitCount(xor) + Integer.bitCount(a & b & xor);
    }
}
