package leetcode.p1900.p1980;

public class Solution {
    public String findDifferentBinaryString(String[] nums) {
        var ans = new StringBuilder();
        for (int i = 0; i < nums.length; i++) ans.append(nums[i].charAt(i) == '0' ? '1' : '0');
        return ans.toString();
    }
}
