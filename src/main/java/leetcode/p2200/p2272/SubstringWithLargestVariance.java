package leetcode.p2200.p2272;

public class SubstringWithLargestVariance {
    public int largestVariance(String s) {
        int len = s.length();
        var freq = new int[26];
        for (var c : s.toCharArray()) freq[c - 'a']++;
        int res = 0;
        for (int c1 = 0; c1 < 26; c1++) {
            for (int c2 = 0; c2 < 26; c2++) {
                if (c1 == c2) continue;
                int total1 = freq[c1];
                int total2 = freq[c2];
                if (total1 == 0 || total2 == 0) continue;
                int count1 = 0;
                int count2 = 0;
                for (var c : s.toCharArray()) {
                    int c0 = c - 'a';
                    if (c0 == c1) {
                        total1--;
                        count1++;
                    } else if (c0 == c2) {
                        total2--;
                        count2++;
                    }

                    if (count2 > 0) res = Math.max(res, count1 - count2);
                    if (total1 > 0 && total2 > 0 && count1 < count2) {
                        count1 = 0;
                        count2 = 0;
                    }
                }
            }
        }
        return res;
    }
}
