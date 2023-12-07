package leetcode.p2200.p2264;

public class Solution {
    public String largestGoodInteger(String num) {
        String res = "";
        for (int i = 0; i < num.length() - 2; i++) {
            if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i + 1) == num.charAt(i + 2)) {
                String cur = num.substring(i, i + 3);
                res = res.compareTo(cur) > 0 ? res : cur;
            }
        }
        return res;
    }
}
