package leetcode.p0300.p0389;

public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        char res = 0;
        for (char c : s.toCharArray()) res ^= c;
        for (char c : t.toCharArray()) res ^= c;
        return res;
    }
}
