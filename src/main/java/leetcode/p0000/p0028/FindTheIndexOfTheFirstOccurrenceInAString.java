package leetcode.p0000.p0028;

public class FindTheIndexOfTheFirstOccurrenceInAString {
    public int strStr(String haystack, String needle) {
        return slidingWindow(haystack, needle);
    }

    private int slidingWindow(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 < len2) return -1;
        for (int i = 0; i <= len1 - len2; i++) {
            int j = 0;
            while (j < len2) {
                if (s1.charAt(i + j) != s2.charAt(j)) break;
                j++;
            }
            if (j == len2) return i;
        }
        return -1;
    }
}
