class Solution {
    fun backspaceCompare(s: String, t: String): Boolean {
        var si = s.length - 1
        var ti = t.length - 1
        var scount = 0
        var tcount = 0
        while (si != -1 || ti != -1) {
            while (si > -1 && (s[si] == '#' || scount != 0)) {
                if (s[si] == '#') scount++
                else scount--
                si--
            }
            while (ti > -1 && (t[ti] == '#' || tcount != 0)) {
                if (t[ti] == '#') tcount++
                else tcount--
                ti--
            }
            val sc = if (si == -1) '*' else s[si]
            val tc = if (ti == -1) '*' else t[ti]
            if (sc != tc) return false
            if (si != -1) si--
            if (ti != -1) ti--
        }
        return true
    }
}