package leetcode.p0800.p0844;

public class Solution {
    public boolean backspaceCompare(String s, String t) {
        int si = s.length() - 1, ti = t.length() - 1;
        int scount = 0, tcount = 0;
        while (si != -1 || ti != -1) {
            while (si > -1 && (s.charAt(si) == '#' || scount != 0)) {
                if (s.charAt(si) == '#') scount++;
                else scount--;
                si--;
            }
            while (ti > -1 && (t.charAt(ti) == '#' || tcount != 0)) {
                if (t.charAt(ti) == '#') tcount++;
                else tcount--;
                ti--;
            }

            char sc = (si == -1) ? '*' : s.charAt(si);
            char tc = (ti == -1) ? '*' : t.charAt(ti);
            if (sc != tc) return false;
            if (si != -1) si--;
            if (ti != -1) ti--;
        }
        return true;
    }
}
