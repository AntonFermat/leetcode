package leetcode.p0700.p0744;

public class FindSmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        int len = letters.length;
        int l = 0, r = len;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (target >= letters[m]) {
                l = m + 1;
            } else r = m;
        }
        return letters[r % len];
    }
}
