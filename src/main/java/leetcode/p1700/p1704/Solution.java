package leetcode.p1700.p1704;

import java.util.Set;

public class Solution {
    public boolean halvesAreAlike(String s) {
        var set = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        int len = s.length();
        int count = 0;
        for(int i = 0; i < len; i++) {
            if(set.contains(s.charAt(i))) count = count + (i < len / 2 ? 1 : -1);
        }
        return count == 0;
    }
}
