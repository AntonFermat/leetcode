package leetcode.p0300.p0392;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int si = s.length(), ti = t.length();
        if (si > ti) return false;
        while (si > 0 && ti > 0) {
            if (s.charAt(si - 1) == t.charAt(ti - 1)) {
                si--;
                ti--;
            } else ti--;
        }
        return si == 0;
    }
}
