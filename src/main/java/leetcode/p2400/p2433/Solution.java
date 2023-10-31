package leetcode.p2400.p2433;

public class Solution {
    public int[] findArray(int[] pref) {
        var res = new int[pref.length];
        res[0] = pref[0];
        for (int i = 1; i < pref.length; i++) res[i] = pref[i - 1] ^ pref[i];
        return res;
    }
}
