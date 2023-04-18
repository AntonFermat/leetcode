package leetcode.p1700.p1768;

public class MergeStringsAlternately {
    public String mergeAlternately(String word1, String word2) {
        int l1 = word1.length(), l2 = word2.length();
        var sb = new StringBuilder();
        int i = 0;
        while (i < Math.min(l1, l2)) sb.append(word1.charAt(i)).append(word2.charAt(i++));
        if (l1 > l2) sb.append(word1.substring(i));
        else if (l1 < l2) sb.append(word2.substring(i));
        return sb.toString();
    }
}
